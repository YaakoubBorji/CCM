package com.yaakoub.cryptocurrencymarket.security;

import com.yaakoub.cryptocurrencymarket.Service.CryptoCurrencyUserService;
import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;
import java.util.Collection;

public abstract class AbstractUserDetailsService implements UserDetailsService {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    CryptoCurrencyUserService cryptoCurrencyUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return _loadUserByUsername(username);
    }

    private UserDetails _loadUserByUsername(final String aUsername) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setReadOnly(true);

        return new TransactionTemplate(transactionManager, transactionDefinition).execute(status -> {
            if (aUsername == null || aUsername.isEmpty()) {
                throw new UsernameNotFoundException("Empty Username");
            }

            User user = getUser(aUsername);

            if (user == null) {
                throw new UsernameNotFoundException("Invalid username " + aUsername
                        + ". No user with this name is defined and enabled in the system.");
            }

            return new ServerSideUser(user.getId(),user.getUserName(),"{noop}"+user.getFamilyName(),user.getFamilyName(),findAuthorities(user));
        });
    }

    protected User getUser(final String username) {
        User user = cryptoCurrencyUserService.getCryptoCurrencyUserById(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user " + username + " is not found.");
        }
        return user;
    }

    /**
     * Return the user authorities
     *
     * @param user
     * @return
     */
    protected abstract Collection<GrantedAuthority> findAuthorities(User user);
}


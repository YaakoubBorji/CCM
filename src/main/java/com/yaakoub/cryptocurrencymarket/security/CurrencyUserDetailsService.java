package com.yaakoub.cryptocurrencymarket.security;

import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class CurrencyUserDetailsService extends AbstractUserDetailsService {

    @Override
    protected Collection<GrantedAuthority> findAuthorities(User user) {
        Collection<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().toString()));
        return grantedAuthority;
    }
}

package com.yaakoub.cryptocurrencymarket.security;

import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public ServerSideUser getServerSideUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof RunAsUserToken)
            return null;
        else if (authentication.getPrincipal() instanceof ServerSideUser)
            return (ServerSideUser) authentication.getPrincipal();
        else
            throw new UsernameNotFoundException("User instance type not recognized.");
    }
}

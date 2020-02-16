package com.yaakoub.cryptocurrencymarket.security;

import com.yaakoub.cryptocurrencymarket.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class CurrencyUserDetailsService extends AbstractUserDetailsService {

    @Override
    protected Collection<GrantedAuthority> findAuthorities(User user) {
        return new ArrayList<GrantedAuthority>();
    }
}

package com.yaakoub.cryptocurrencymarket.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@Setter
@ToString
public class ServerSideUser extends User implements Cloneable {

    private final String familyName;
    private final Long userId;

    public ServerSideUser(Long userId, String username, String password,String familyName, Collection<? extends GrantedAuthority> authorities) {
        super(username, password,true, true, true, true,  authorities);
        this.familyName= familyName;
        this.userId=userId;
    }
}

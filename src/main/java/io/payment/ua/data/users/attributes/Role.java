package io.payment.ua.data.users.attributes;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public enum Role {
    ROLE_USER;

    public Set<GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority(this.name()));
    }
}

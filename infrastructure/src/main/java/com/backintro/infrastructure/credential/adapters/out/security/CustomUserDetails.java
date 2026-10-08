package com.backintro.infrastructure.credential.adapters.out.security;

import com.backintro.domain.credential.model.aggregate.Credential;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class CustomUserDetails implements UserDetails {

    private final Credential credential;

    public CustomUserDetails(Credential credential) {
        this.credential = credential;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + credential.role().name()));
    }

    @Override
    public String getPassword() {
        return credential.passwordHash();
    }

    @Override
    public String getUsername() {
        return credential.username();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return credential.isEnabled();
    }

    public UUID getProfessionalId() {
        return credential.professionalId();
    }

    public Credential getCredential() {
        return credential;
    }
}

package com.backintro.infrastructure.credential.adapters.out.security;

import com.backintro.domain.credential.port.CredentialRepositoryPort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CredentialRepositoryPort credentialRepositoryPort;

    public CustomUserDetailsService(CredentialRepositoryPort credentialRepositoryPort) {
        this.credentialRepositoryPort = credentialRepositoryPort;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return credentialRepositoryPort.findByUsername(username)
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con username: " + username));
    }
}

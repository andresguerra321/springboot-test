package com.backintro.infrastructure.credential.adapters.out.security;

import com.backintro.application.credential.port.TokenIssuerPort;
import com.backintro.domain.credential.model.aggregate.Credential;

public class JwtTokenIssuerAdapter implements TokenIssuerPort {

    private final JwtService jwtService;

    public JwtTokenIssuerAdapter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public String issueToken(Credential credential) {
        return jwtService.generateToken(
                credential.username(),
                credential.professionalId(),
                credential.role().name()
        );
    }
}


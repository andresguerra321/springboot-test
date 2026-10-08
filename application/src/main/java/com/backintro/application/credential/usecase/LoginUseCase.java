package com.backintro.application.credential.usecase;

import com.backintro.application.credential.exception.InvalidCredentialsException;
import com.backintro.application.credential.port.PasswordEncoderPort;
import com.backintro.application.credential.port.TokenIssuerPort;
import com.backintro.domain.credential.model.aggregate.Credential;
import com.backintro.domain.credential.port.CredentialRepositoryPort;

import java.util.Optional;

public class LoginUseCase {

    private final CredentialRepositoryPort credentialRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final TokenIssuerPort tokenIssuerPort;

    public LoginUseCase(CredentialRepositoryPort credentialRepositoryPort,
                        PasswordEncoderPort passwordEncoderPort,
                        TokenIssuerPort tokenIssuerPort) {
        this.credentialRepositoryPort = credentialRepositoryPort;
        this.passwordEncoderPort = passwordEncoderPort;
        this.tokenIssuerPort = tokenIssuerPort;
    }

    public String execute(String username, String rawPassword) {
        Optional<Credential> credentialOpt = credentialRepositoryPort.findByUsername(username);
        
        if (credentialOpt.isEmpty()) {
            throw new InvalidCredentialsException();
        }

        Credential credential = credentialOpt.get();

        if (!credential.isEnabled()) {
            throw new InvalidCredentialsException();
        }

        if (!passwordEncoderPort.matches(rawPassword, credential.passwordHash())) {
            throw new InvalidCredentialsException();
        }

        return tokenIssuerPort.issueToken(credential);
    }
}

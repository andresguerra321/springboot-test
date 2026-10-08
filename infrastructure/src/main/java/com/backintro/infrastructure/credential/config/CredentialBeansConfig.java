package com.backintro.infrastructure.credential.config;

import com.backintro.application.credential.port.PasswordEncoderPort;
import com.backintro.application.credential.port.TokenIssuerPort;
import com.backintro.application.credential.usecase.LoginUseCase;
import com.backintro.domain.credential.port.CredentialRepositoryPort;
import com.backintro.infrastructure.credential.adapters.out.security.BcryptPasswordEncoderAdapter;
import com.backintro.infrastructure.credential.adapters.out.security.JwtService;
import com.backintro.infrastructure.credential.adapters.out.security.JwtTokenIssuerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class CredentialBeansConfig {

    @Bean
    public PasswordEncoderPort passwordEncoderPort(PasswordEncoder passwordEncoder) {
        return new BcryptPasswordEncoderAdapter(passwordEncoder);
    }

    @Bean
    public TokenIssuerPort tokenIssuerPort(JwtService jwtService) {
        return new JwtTokenIssuerAdapter(jwtService);
    }

    @Bean
    public LoginUseCase loginUseCase(
            CredentialRepositoryPort credentialRepositoryPort,
            PasswordEncoderPort passwordEncoderPort,
            TokenIssuerPort tokenIssuerPort) {
        return new LoginUseCase(credentialRepositoryPort, passwordEncoderPort, tokenIssuerPort);
    }
}

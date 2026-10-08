package com.backintro.application.credential.port;

import com.backintro.domain.credential.model.aggregate.Credential;

public interface TokenIssuerPort {
    String issueToken(Credential credential);
}

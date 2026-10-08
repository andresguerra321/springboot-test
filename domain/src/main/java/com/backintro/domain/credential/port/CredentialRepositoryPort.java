package com.backintro.domain.credential.port;

import java.util.Optional;
import java.util.UUID;
import com.backintro.domain.credential.model.aggregate.Credential;
import com.backintro.domain.credential.model.valueobject.CredentialId;

public interface CredentialRepositoryPort {
    Credential save(Credential credential);
    Optional<Credential> findById(CredentialId id);
    Optional<Credential> findByUsername(String username);
    Optional<Credential> findByProfessionalId(UUID professionalId);
}

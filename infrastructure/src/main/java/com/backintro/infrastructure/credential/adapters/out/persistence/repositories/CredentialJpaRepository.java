package com.backintro.infrastructure.credential.adapters.out.persistence.repositories;

import com.backintro.infrastructure.credential.adapters.out.persistence.entity.CredentialJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CredentialJpaRepository extends JpaRepository<CredentialJpaEntity, UUID> {
    Optional<CredentialJpaEntity> findByUsername(String username);
    Optional<CredentialJpaEntity> findByProfessionalId(UUID professionalId);
}

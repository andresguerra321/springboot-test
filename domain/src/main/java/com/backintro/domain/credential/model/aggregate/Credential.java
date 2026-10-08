package com.backintro.domain.credential.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.credential.model.valueobject.CredentialId;
import com.backintro.domain.credential.model.valueobject.Role;

public class Credential extends AggregateRoot {
    private final CredentialId id;
    private final UUID professionalId;
    private final String username;
    private String passwordHash;
    private Role role;
    private boolean enabled;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Credential(
        CredentialId id,
        UUID professionalId,
        String username,
        String passwordHash,
        Role role,
        boolean enabled,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.username = Objects.requireNonNull(username, "username must not be null");
        this.passwordHash = Objects.requireNonNull(passwordHash, "passwordHash must not be null");
        this.role = Objects.requireNonNull(role, "role must not be null");
        this.enabled = enabled;
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt must not be null");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt must not be null");
    }

    public static Credential create(
        UUID professionalId,
        String username,
        String passwordHash,
        Role role) {
        
        return new Credential(
            CredentialId.generate(),
            professionalId,
            username,
            passwordHash,
            role,
            true,
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }

    public static Credential restore(
        CredentialId id,
        UUID professionalId,
        String username,
        String passwordHash,
        Role role,
        boolean enabled,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
        
        return new Credential(
            id,
            professionalId,
            username,
            passwordHash,
            role,
            enabled,
            createdAt,
            updatedAt
        );
    }

    public void updatePassword(String newPasswordHash) {
        this.passwordHash = Objects.requireNonNull(newPasswordHash);
        this.updatedAt = LocalDateTime.now();
    }

    public void updateRole(Role newRole) {
        this.role = Objects.requireNonNull(newRole);
        this.updatedAt = LocalDateTime.now();
    }

    public void disable() {
        this.enabled = false;
        this.updatedAt = LocalDateTime.now();
    }

    public void enable() {
        this.enabled = true;
        this.updatedAt = LocalDateTime.now();
    }

    public CredentialId id() { return id; }
    public UUID professionalId() { return professionalId; }
    public String username() { return username; }
    public String passwordHash() { return passwordHash; }
    public Role role() { return role; }
    public boolean enabled() { return enabled; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }

    public CredentialId getId() { return id(); }
    public UUID getProfessionalId() { return professionalId(); }
    public String getUsername() { return username(); }
    public String getPasswordHash() { return passwordHash(); }
    public Role getRole() { return role(); }
    public boolean isEnabled() { return enabled(); }
    public LocalDateTime getCreatedAt() { return createdAt(); }
    public LocalDateTime getUpdatedAt() { return updatedAt(); }
}

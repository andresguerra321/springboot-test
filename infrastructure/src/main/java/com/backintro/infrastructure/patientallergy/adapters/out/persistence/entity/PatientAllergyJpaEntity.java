package com.backintro.infrastructure.patientallergy.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient_allergies")
public class PatientAllergyJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;
    @Column(name = "substance", nullable = false, length = 200)
    private String substance;
    @Column(name = "reaction", nullable = true)
    private String reaction;
    @Column(name = "severity", nullable = true, length = 20)
    private String severity;
    @Column(name = "active", nullable = true)
    private Boolean active;
    @Column(name = "recorded_at", nullable = true)
    private java.time.LocalDateTime recordedAt;
    @Column(name = "recorded_by", nullable = true)
    private UUID recordedBy;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public PatientAllergyJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
        if (this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getPatientId() {
        return patientId;
    }
    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
    public String getSubstance() {
        return substance;
    }
    public void setSubstance(String substance) {
        this.substance = substance;
    }
    public String getReaction() {
        return reaction;
    }
    public void setReaction(String reaction) {
        this.reaction = reaction;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public Boolean isActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public java.time.LocalDateTime getRecordedAt() {
        return recordedAt;
    }
    public void setRecordedAt(java.time.LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
    public UUID getRecordedBy() {
        return recordedBy;
    }
    public void setRecordedBy(UUID recordedBy) {
        this.recordedBy = recordedBy;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientAllergyJpaEntity that = (PatientAllergyJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
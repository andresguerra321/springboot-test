package com.backintro.infrastructure.clinicalnote.adapters.out.persistence.entity;

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
@Table(name = "clinical_notes")
public class ClinicalNoteJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "encounter_id", nullable = false)
    private UUID encounterId;
    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;
    @Column(name = "subjective", nullable = true)
    private String subjective;
    @Column(name = "objective", nullable = true)
    private String objective;
    @Column(name = "assessment", nullable = true)
    private String assessment;
    @Column(name = "plan", nullable = true)
    private String plan;
    @Column(name = "additional_notes", nullable = true)
    private String additionalNotes;
    @Column(name = "signed_at", nullable = true)
    private java.time.LocalDateTime signedAt;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public ClinicalNoteJpaEntity() {}

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

    public UUID getEncounterId() {
        return encounterId;
    }
    public void setEncounterId(UUID encounterId) {
        this.encounterId = encounterId;
    }
    public UUID getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(UUID professionalId) {
        this.professionalId = professionalId;
    }
    public String getSubjective() {
        return subjective;
    }
    public void setSubjective(String subjective) {
        this.subjective = subjective;
    }
    public String getObjective() {
        return objective;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public String getAssessment() {
        return assessment;
    }
    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    public String getAdditionalNotes() {
        return additionalNotes;
    }
    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
    public java.time.LocalDateTime getSignedAt() {
        return signedAt;
    }
    public void setSignedAt(java.time.LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalNoteJpaEntity that = (ClinicalNoteJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
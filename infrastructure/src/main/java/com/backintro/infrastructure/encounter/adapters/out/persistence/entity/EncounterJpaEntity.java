package com.backintro.infrastructure.encounter.adapters.out.persistence.entity;

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
@Table(name = "encounters")
public class EncounterJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "clinical_record_id", nullable = false)
    private UUID clinicalRecordId;
    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;
    @Column(name = "encounter_type_id", nullable = false)
    private UUID encounterTypeId;
    @Column(name = "started_at", nullable = false)
    private java.time.LocalDateTime startedAt;
    @Column(name = "ended_at", nullable = true)
    private java.time.LocalDateTime endedAt;
    @Column(name = "reason_for_visit", nullable = true)
    private String reasonForVisit;
    @Column(name = "current_condition", nullable = true)
    private String currentCondition;
    @Column(name = "modality_id", nullable = false)
    private UUID modalityId;
    @Column(name = "status_id", nullable = false)
    private UUID statusId;
    @Column(name = "created_by", nullable = true)
    private UUID createdBy;
    @Column(name = "updated_by", nullable = true)
    private UUID updatedBy;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public EncounterJpaEntity() {}

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

    public UUID getClinicalRecordId() {
        return clinicalRecordId;
    }
    public void setClinicalRecordId(UUID clinicalRecordId) {
        this.clinicalRecordId = clinicalRecordId;
    }
    public UUID getProfessionalId() {
        return professionalId;
    }
    public void setProfessionalId(UUID professionalId) {
        this.professionalId = professionalId;
    }
    public UUID getEncounterTypeId() {
        return encounterTypeId;
    }
    public void setEncounterTypeId(UUID encounterTypeId) {
        this.encounterTypeId = encounterTypeId;
    }
    public java.time.LocalDateTime getStartedAt() {
        return startedAt;
    }
    public void setStartedAt(java.time.LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }
    public java.time.LocalDateTime getEndedAt() {
        return endedAt;
    }
    public void setEndedAt(java.time.LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }
    public String getReasonForVisit() {
        return reasonForVisit;
    }
    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }
    public String getCurrentCondition() {
        return currentCondition;
    }
    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }
    public UUID getModalityId() {
        return modalityId;
    }
    public void setModalityId(UUID modalityId) {
        this.modalityId = modalityId;
    }
    public UUID getStatusId() {
        return statusId;
    }
    public void setStatusId(UUID statusId) {
        this.statusId = statusId;
    }
    public UUID getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
    public UUID getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterJpaEntity that = (EncounterJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
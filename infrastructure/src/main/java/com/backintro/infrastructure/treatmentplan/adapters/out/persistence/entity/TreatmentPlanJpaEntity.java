package com.backintro.infrastructure.treatmentplan.adapters.out.persistence.entity;

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
@Table(name = "treatment_plans")
public class TreatmentPlanJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "encounter_id", nullable = false)
    private UUID encounterId;
    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;
    @Column(name = "title", nullable = false, length = 200)
    private String title;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "start_date", nullable = true)
    private java.time.LocalDate startDate;
    @Column(name = "end_date", nullable = true)
    private java.time.LocalDate endDate;
    @Column(name = "treatment_status_id", nullable = false)
    private UUID treatmentStatusId;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public TreatmentPlanJpaEntity() {}

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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public java.time.LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(java.time.LocalDate startDate) {
        this.startDate = startDate;
    }
    public java.time.LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(java.time.LocalDate endDate) {
        this.endDate = endDate;
    }
    public UUID getTreatmentStatusId() {
        return treatmentStatusId;
    }
    public void setTreatmentStatusId(UUID treatmentStatusId) {
        this.treatmentStatusId = treatmentStatusId;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentPlanJpaEntity that = (TreatmentPlanJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
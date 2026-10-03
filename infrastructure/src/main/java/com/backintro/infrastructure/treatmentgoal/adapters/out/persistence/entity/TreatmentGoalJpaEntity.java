package com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.entity;

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
@Table(name = "treatment_goals")
public class TreatmentGoalJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "treatment_plan_id", nullable = false)
    private UUID treatmentPlanId;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "target_date", nullable = true)
    private java.time.LocalDate targetDate;
    @Column(name = "completed_at", nullable = true)
    private java.time.LocalDateTime completedAt;
    @Column(name = "notes", nullable = true)
    private String notes;
    @Column(name = "treatment_goal_status_id", nullable = false)
    private UUID treatmentGoalStatusId;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public TreatmentGoalJpaEntity() {}

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

    public UUID getTreatmentPlanId() {
        return treatmentPlanId;
    }
    public void setTreatmentPlanId(UUID treatmentPlanId) {
        this.treatmentPlanId = treatmentPlanId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public java.time.LocalDate getTargetDate() {
        return targetDate;
    }
    public void setTargetDate(java.time.LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    public java.time.LocalDateTime getCompletedAt() {
        return completedAt;
    }
    public void setCompletedAt(java.time.LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public UUID getTreatmentGoalStatusId() {
        return treatmentGoalStatusId;
    }
    public void setTreatmentGoalStatusId(UUID treatmentGoalStatusId) {
        this.treatmentGoalStatusId = treatmentGoalStatusId;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentGoalJpaEntity that = (TreatmentGoalJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
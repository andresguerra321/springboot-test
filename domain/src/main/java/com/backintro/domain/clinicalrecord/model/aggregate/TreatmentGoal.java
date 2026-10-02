package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class TreatmentGoal {

    private UUID id;
    private UUID treatmentPlanId;
    private String description;
    private LocalDate targetDate;
    private LocalDateTime completedAt;
    private String notes;
    private UUID treatmentGoalStatusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TreatmentGoal() {
    }

    public TreatmentGoal(UUID id, UUID treatmentPlanId, String description, LocalDate targetDate,
                         LocalDateTime completedAt, String notes, UUID treatmentGoalStatusId,
                         LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.treatmentPlanId = treatmentPlanId;
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalStatusId = treatmentGoalStatusId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static TreatmentGoal create(UUID treatmentPlanId, String description, LocalDate targetDate,
                                       UUID treatmentGoalStatusId) {
        LocalDateTime now = LocalDateTime.now();
        return new TreatmentGoal(
                UUID.randomUUID(),
                treatmentPlanId,
                description,
                targetDate,
                null,
                null,
                treatmentGoalStatusId,
                now,
                now
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentGoal that = (TreatmentGoal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

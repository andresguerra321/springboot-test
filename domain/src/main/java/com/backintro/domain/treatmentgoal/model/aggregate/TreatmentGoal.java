package com.backintro.domain.treatmentgoal.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentgoal.event.TreatmentGoalRegisteredEvent;
import com.backintro.domain.treatmentgoal.event.TreatmentGoalUpdatedEvent;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

public class TreatmentGoal extends AggregateRoot {
    private final TreatmentGoalId id;
    private UUID treatmentPlanId;
    private String description;
    private java.time.LocalDate targetDate;
    private java.time.LocalDateTime completedAt;
    private String notes;
    private UUID treatmentGoalStatusId;

    private TreatmentGoal(
        TreatmentGoalId id,
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.treatmentPlanId = Objects.requireNonNull(treatmentPlanId, "treatmentPlanId must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalStatusId = Objects.requireNonNull(treatmentGoalStatusId, "treatmentGoalStatusId must not be null");
    }

    public static TreatmentGoal register(
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId) {

        TreatmentGoalId id = TreatmentGoalId.generate();

        TreatmentGoal entity = new TreatmentGoal(
            id,
            treatmentPlanId,
            description,
            targetDate,
            completedAt,
            notes,
            treatmentGoalStatusId);

        entity.recordEvent(
            new TreatmentGoalRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static TreatmentGoal restore(
        TreatmentGoalId id,
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId) {
        return new TreatmentGoal(
            id,
            treatmentPlanId,
            description,
            targetDate,
            completedAt,
            notes,
            treatmentGoalStatusId);
    }

    public void update(
        UUID treatmentPlanId,
        String description,
        java.time.LocalDate targetDate,
        java.time.LocalDateTime completedAt,
        String notes,
        UUID treatmentGoalStatusId) {

        this.treatmentPlanId = Objects.requireNonNull(treatmentPlanId);
        this.description = Objects.requireNonNull(description);
        this.targetDate = targetDate;
        this.completedAt = completedAt;
        this.notes = notes;
        this.treatmentGoalStatusId = Objects.requireNonNull(treatmentGoalStatusId);

        recordEvent(
            new TreatmentGoalUpdatedEvent(
                this.id,
                this.treatmentPlanId,
                this.description,
                this.targetDate,
                this.completedAt,
                this.notes,
                this.treatmentGoalStatusId,
                LocalDateTime.now()));
    }

    public TreatmentGoalId id() {
        return id;
    }

    public UUID treatmentPlanId() {
        return treatmentPlanId;
    }
    public String description() {
        return description;
    }
    public java.time.LocalDate targetDate() {
        return targetDate;
    }
    public java.time.LocalDateTime completedAt() {
        return completedAt;
    }
    public String notes() {
        return notes;
    }
    public UUID treatmentGoalStatusId() {
        return treatmentGoalStatusId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public TreatmentGoalId getId() {
        return id();
    }

    public UUID getTreatmentPlanId() {
        return treatmentPlanId();
    }
    public String getDescription() {
        return description();
    }
    public java.time.LocalDate getTargetDate() {
        return targetDate();
    }
    public java.time.LocalDateTime getCompletedAt() {
        return completedAt();
    }
    public String getNotes() {
        return notes();
    }
    public UUID getTreatmentGoalStatusId() {
        return treatmentGoalStatusId();
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

    @Override
    public String toString() {
        return "TreatmentGoal{" +
                "id=" + id +
                '}';
    }
}
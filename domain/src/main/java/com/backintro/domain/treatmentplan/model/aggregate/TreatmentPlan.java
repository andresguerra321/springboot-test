package com.backintro.domain.treatmentplan.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentplan.event.TreatmentPlanRegisteredEvent;
import com.backintro.domain.treatmentplan.event.TreatmentPlanUpdatedEvent;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;

public class TreatmentPlan extends AggregateRoot {
    private final TreatmentPlanId id;
    private UUID encounterId;
    private UUID professionalId;
    private String title;
    private String description;
    private java.time.LocalDate startDate;
    private java.time.LocalDate endDate;
    private UUID treatmentStatusId;

    private TreatmentPlan(
        TreatmentPlanId id,
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        java.time.LocalDate startDate,
        java.time.LocalDate endDate,
        UUID treatmentStatusId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.title = Objects.requireNonNull(title, "title must not be null");
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatmentStatusId = Objects.requireNonNull(treatmentStatusId, "treatmentStatusId must not be null");
    }

    public static TreatmentPlan register(
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        java.time.LocalDate startDate,
        java.time.LocalDate endDate,
        UUID treatmentStatusId) {

        TreatmentPlanId id = TreatmentPlanId.generate();

        TreatmentPlan entity = new TreatmentPlan(
            id,
            encounterId,
            professionalId,
            title,
            description,
            startDate,
            endDate,
            treatmentStatusId);

        entity.recordEvent(
            new TreatmentPlanRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static TreatmentPlan restore(
        TreatmentPlanId id,
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        java.time.LocalDate startDate,
        java.time.LocalDate endDate,
        UUID treatmentStatusId) {
        return new TreatmentPlan(
            id,
            encounterId,
            professionalId,
            title,
            description,
            startDate,
            endDate,
            treatmentStatusId);
    }

    public void update(
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        java.time.LocalDate startDate,
        java.time.LocalDate endDate,
        UUID treatmentStatusId) {

        this.encounterId = Objects.requireNonNull(encounterId);
        this.professionalId = Objects.requireNonNull(professionalId);
        this.title = Objects.requireNonNull(title);
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.treatmentStatusId = Objects.requireNonNull(treatmentStatusId);

        recordEvent(
            new TreatmentPlanUpdatedEvent(
                this.id,
                this.encounterId,
                this.professionalId,
                this.title,
                this.description,
                this.startDate,
                this.endDate,
                this.treatmentStatusId,
                LocalDateTime.now()));
    }

    public TreatmentPlanId id() {
        return id;
    }

    public UUID encounterId() {
        return encounterId;
    }
    public UUID professionalId() {
        return professionalId;
    }
    public String title() {
        return title;
    }
    public String description() {
        return description;
    }
    public java.time.LocalDate startDate() {
        return startDate;
    }
    public java.time.LocalDate endDate() {
        return endDate;
    }
    public UUID treatmentStatusId() {
        return treatmentStatusId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public TreatmentPlanId getId() {
        return id();
    }

    public UUID getEncounterId() {
        return encounterId();
    }
    public UUID getProfessionalId() {
        return professionalId();
    }
    public String getTitle() {
        return title();
    }
    public String getDescription() {
        return description();
    }
    public java.time.LocalDate getStartDate() {
        return startDate();
    }
    public java.time.LocalDate getEndDate() {
        return endDate();
    }
    public UUID getTreatmentStatusId() {
        return treatmentStatusId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreatmentPlan that = (TreatmentPlan) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TreatmentPlan{" +
                "id=" + id +
                '}';
    }
}
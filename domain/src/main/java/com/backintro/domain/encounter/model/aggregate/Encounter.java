package com.backintro.domain.encounter.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encounter.event.EncounterRegisteredEvent;
import com.backintro.domain.encounter.event.EncounterUpdatedEvent;
import com.backintro.domain.encounter.model.valueobject.EncounterId;

public class Encounter extends AggregateRoot {
    private final EncounterId id;
    private UUID clinicalRecordId;
    private UUID professionalId;
    private UUID encounterTypeId;
    private java.time.LocalDateTime startedAt;
    private java.time.LocalDateTime endedAt;
    private String reasonForVisit;
    private String currentCondition;
    private UUID modalityId;
    private UUID statusId;
    private UUID createdBy;
    private UUID updatedBy;

    private Encounter(
        EncounterId id,
        UUID clinicalRecordId,
        UUID professionalId,
        UUID encounterTypeId,
        java.time.LocalDateTime startedAt,
        java.time.LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        UUID statusId,
        UUID createdBy,
        UUID updatedBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.clinicalRecordId = Objects.requireNonNull(clinicalRecordId, "clinicalRecordId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.encounterTypeId = Objects.requireNonNull(encounterTypeId, "encounterTypeId must not be null");
        this.startedAt = Objects.requireNonNull(startedAt, "startedAt must not be null");
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = Objects.requireNonNull(modalityId, "modalityId must not be null");
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public static Encounter register(
        UUID clinicalRecordId,
        UUID professionalId,
        UUID encounterTypeId,
        java.time.LocalDateTime startedAt,
        java.time.LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        UUID statusId,
        UUID createdBy,
        UUID updatedBy) {

        EncounterId id = EncounterId.generate();

        Encounter entity = new Encounter(
            id,
            clinicalRecordId,
            professionalId,
            encounterTypeId,
            startedAt,
            endedAt,
            reasonForVisit,
            currentCondition,
            modalityId,
            statusId,
            createdBy,
            updatedBy);

        entity.recordEvent(
            new EncounterRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Encounter restore(
        EncounterId id,
        UUID clinicalRecordId,
        UUID professionalId,
        UUID encounterTypeId,
        java.time.LocalDateTime startedAt,
        java.time.LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        UUID statusId,
        UUID createdBy,
        UUID updatedBy) {
        return new Encounter(
            id,
            clinicalRecordId,
            professionalId,
            encounterTypeId,
            startedAt,
            endedAt,
            reasonForVisit,
            currentCondition,
            modalityId,
            statusId,
            createdBy,
            updatedBy);
    }

    public void update(
        UUID clinicalRecordId,
        UUID professionalId,
        UUID encounterTypeId,
        java.time.LocalDateTime startedAt,
        java.time.LocalDateTime endedAt,
        String reasonForVisit,
        String currentCondition,
        UUID modalityId,
        UUID statusId,
        UUID createdBy,
        UUID updatedBy) {

        this.clinicalRecordId = Objects.requireNonNull(clinicalRecordId);
        this.professionalId = Objects.requireNonNull(professionalId);
        this.encounterTypeId = Objects.requireNonNull(encounterTypeId);
        this.startedAt = Objects.requireNonNull(startedAt);
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = Objects.requireNonNull(modalityId);
        this.statusId = Objects.requireNonNull(statusId);
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;

        recordEvent(
            new EncounterUpdatedEvent(
                this.id,
                this.clinicalRecordId,
                this.professionalId,
                this.encounterTypeId,
                this.startedAt,
                this.endedAt,
                this.reasonForVisit,
                this.currentCondition,
                this.modalityId,
                this.statusId,
                this.createdBy,
                this.updatedBy,
                LocalDateTime.now()));
    }

    public EncounterId id() {
        return id;
    }

    public UUID clinicalRecordId() {
        return clinicalRecordId;
    }
    public UUID professionalId() {
        return professionalId;
    }
    public UUID encounterTypeId() {
        return encounterTypeId;
    }
    public java.time.LocalDateTime startedAt() {
        return startedAt;
    }
    public java.time.LocalDateTime endedAt() {
        return endedAt;
    }
    public String reasonForVisit() {
        return reasonForVisit;
    }
    public String currentCondition() {
        return currentCondition;
    }
    public UUID modalityId() {
        return modalityId;
    }
    public UUID statusId() {
        return statusId;
    }
    public UUID createdBy() {
        return createdBy;
    }
    public UUID updatedBy() {
        return updatedBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public EncounterId getId() {
        return id();
    }

    public UUID getClinicalRecordId() {
        return clinicalRecordId();
    }
    public UUID getProfessionalId() {
        return professionalId();
    }
    public UUID getEncounterTypeId() {
        return encounterTypeId();
    }
    public java.time.LocalDateTime getStartedAt() {
        return startedAt();
    }
    public java.time.LocalDateTime getEndedAt() {
        return endedAt();
    }
    public String getReasonForVisit() {
        return reasonForVisit();
    }
    public String getCurrentCondition() {
        return currentCondition();
    }
    public UUID getModalityId() {
        return modalityId();
    }
    public UUID getStatusId() {
        return statusId();
    }
    public UUID getCreatedBy() {
        return createdBy();
    }
    public UUID getUpdatedBy() {
        return updatedBy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Encounter that = (Encounter) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "id=" + id +
                '}';
    }
}
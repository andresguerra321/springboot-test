package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.clinicalrecord.event.ClinicalRecordRegisteredEvent;
import com.backintro.domain.clinicalrecord.event.ClinicalRecordUpdatedEvent;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

public class ClinicalRecord extends AggregateRoot {
    private final ClinicalRecordId id;
    private UUID patientId;
    private java.time.LocalDateTime creationDate;
    private String recordNumber;
    private java.time.LocalDateTime openedAt;
    private java.time.LocalDateTime closedAt;
    private UUID statusId;
    private UUID createdBy;

    private ClinicalRecord(
        ClinicalRecordId id,
        UUID patientId,
        java.time.LocalDateTime creationDate,
        String recordNumber,
        java.time.LocalDateTime openedAt,
        java.time.LocalDateTime closedAt,
        UUID statusId,
        UUID createdBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.creationDate = creationDate;
        this.recordNumber = Objects.requireNonNull(recordNumber, "recordNumber must not be null");
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = Objects.requireNonNull(statusId, "statusId must not be null");
        this.createdBy = createdBy;
    }

    public static ClinicalRecord register(
        UUID patientId,
        java.time.LocalDateTime creationDate,
        String recordNumber,
        java.time.LocalDateTime openedAt,
        java.time.LocalDateTime closedAt,
        UUID statusId,
        UUID createdBy) {

        ClinicalRecordId id = ClinicalRecordId.generate();

        ClinicalRecord entity = new ClinicalRecord(
            id,
            patientId,
            creationDate,
            recordNumber,
            openedAt,
            closedAt,
            statusId,
            createdBy);

        entity.recordEvent(
            new ClinicalRecordRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ClinicalRecord restore(
        ClinicalRecordId id,
        UUID patientId,
        java.time.LocalDateTime creationDate,
        String recordNumber,
        java.time.LocalDateTime openedAt,
        java.time.LocalDateTime closedAt,
        UUID statusId,
        UUID createdBy) {
        return new ClinicalRecord(
            id,
            patientId,
            creationDate,
            recordNumber,
            openedAt,
            closedAt,
            statusId,
            createdBy);
    }

    public void update(
        UUID patientId,
        java.time.LocalDateTime creationDate,
        String recordNumber,
        java.time.LocalDateTime openedAt,
        java.time.LocalDateTime closedAt,
        UUID statusId,
        UUID createdBy) {

        this.patientId = Objects.requireNonNull(patientId);
        this.creationDate = creationDate;
        this.recordNumber = Objects.requireNonNull(recordNumber);
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = Objects.requireNonNull(statusId);
        this.createdBy = createdBy;

        recordEvent(
            new ClinicalRecordUpdatedEvent(
                this.id,
                this.patientId,
                this.creationDate,
                this.recordNumber,
                this.openedAt,
                this.closedAt,
                this.statusId,
                this.createdBy,
                LocalDateTime.now()));
    }

    public ClinicalRecordId id() {
        return id;
    }

    public UUID patientId() {
        return patientId;
    }
    public java.time.LocalDateTime creationDate() {
        return creationDate;
    }
    public String recordNumber() {
        return recordNumber;
    }
    public java.time.LocalDateTime openedAt() {
        return openedAt;
    }
    public java.time.LocalDateTime closedAt() {
        return closedAt;
    }
    public UUID statusId() {
        return statusId;
    }
    public UUID createdBy() {
        return createdBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ClinicalRecordId getId() {
        return id();
    }

    public UUID getPatientId() {
        return patientId();
    }
    public java.time.LocalDateTime getCreationDate() {
        return creationDate();
    }
    public String getRecordNumber() {
        return recordNumber();
    }
    public java.time.LocalDateTime getOpenedAt() {
        return openedAt();
    }
    public java.time.LocalDateTime getClosedAt() {
        return closedAt();
    }
    public UUID getStatusId() {
        return statusId();
    }
    public UUID getCreatedBy() {
        return createdBy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecord that = (ClinicalRecord) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClinicalRecord{" +
                "id=" + id +
                '}';
    }
}
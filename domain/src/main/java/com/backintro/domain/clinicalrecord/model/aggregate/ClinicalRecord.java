package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Historia Clínica.
 */
public class ClinicalRecord {

    private UUID id;
    private UUID patientId;
    private LocalDateTime creationDate;
    private String recordNumber;
    private LocalDateTime openedAt;
    private LocalDateTime closedAt;
    private UUID statusId;
    private LocalDateTime createdAt;
    private UUID createdBy;

    public ClinicalRecord() {}

    public ClinicalRecord(UUID id, UUID patientId, LocalDateTime creationDate, String recordNumber,
                          LocalDateTime openedAt, LocalDateTime closedAt, UUID statusId,
                          LocalDateTime createdAt, UUID createdBy) {
        this.id = id;
        this.patientId = patientId;
        this.creationDate = creationDate;
        this.recordNumber = recordNumber;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.statusId = statusId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.createdBy = createdBy;
    }

    public static ClinicalRecord create(UUID patientId, String recordNumber, UUID statusId, UUID createdBy) {
        LocalDateTime now = LocalDateTime.now();
        return new ClinicalRecord(UUID.randomUUID(), patientId, now, recordNumber, now, null, statusId, now, createdBy);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
    public String getRecordNumber() { return recordNumber; }
    public void setRecordNumber(String recordNumber) { this.recordNumber = recordNumber; }
    public LocalDateTime getOpenedAt() { return openedAt; }
    public void setOpenedAt(LocalDateTime openedAt) { this.openedAt = openedAt; }
    public LocalDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(LocalDateTime closedAt) { this.closedAt = closedAt; }
    public UUID getStatusId() { return statusId; }
    public void setStatusId(UUID statusId) { this.statusId = statusId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((ClinicalRecord) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "ClinicalRecord{id=" + id + ", recordNumber='" + recordNumber + "', patientId=" + patientId + "}";
    }
}

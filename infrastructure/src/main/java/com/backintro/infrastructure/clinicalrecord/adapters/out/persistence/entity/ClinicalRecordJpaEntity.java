package com.backintro.infrastructure.clinicalrecord.adapters.out.persistence.entity;

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
@Table(name = "clinical_records")
public class ClinicalRecordJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "patient_id", nullable = false)
    private UUID patientId;
    @Column(name = "creation_date", nullable = true)
    private java.time.LocalDateTime creationDate;
    @Column(name = "record_number", nullable = false, length = 50)
    private String recordNumber;
    @Column(name = "opened_at", nullable = true)
    private java.time.LocalDateTime openedAt;
    @Column(name = "closed_at", nullable = true)
    private java.time.LocalDateTime closedAt;
    @Column(name = "status_id", nullable = false)
    private UUID statusId;
    @Column(name = "created_by", nullable = true)
    private UUID createdBy;
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    public ClinicalRecordJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getPatientId() {
        return patientId;
    }
    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
    public java.time.LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(java.time.LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public String getRecordNumber() {
        return recordNumber;
    }
    public void setRecordNumber(String recordNumber) {
        this.recordNumber = recordNumber;
    }
    public java.time.LocalDateTime getOpenedAt() {
        return openedAt;
    }
    public void setOpenedAt(java.time.LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }
    public java.time.LocalDateTime getClosedAt() {
        return closedAt;
    }
    public void setClosedAt(java.time.LocalDateTime closedAt) {
        this.closedAt = closedAt;
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
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecordJpaEntity that = (ClinicalRecordJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
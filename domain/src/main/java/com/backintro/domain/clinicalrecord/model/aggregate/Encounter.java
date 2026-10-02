package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de Encuentro clínico (sesión/consulta).
 */
public class Encounter {

    private UUID id;
    private UUID clinicalRecordId;
    private UUID professionalId;
    private UUID encounterTypeId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private String reasonForVisit;
    private String currentCondition;
    private UUID modalityId;
    private UUID statusId;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;

    public Encounter() {}

    public Encounter(UUID id, UUID clinicalRecordId, UUID professionalId, UUID encounterTypeId,
                     LocalDateTime startedAt, LocalDateTime endedAt, String reasonForVisit, String currentCondition,
                     UUID modalityId, UUID statusId, LocalDateTime createdAt, UUID createdBy,
                     LocalDateTime updatedAt, UUID updatedBy) {
        this.id = id;
        this.clinicalRecordId = clinicalRecordId;
        this.professionalId = professionalId;
        this.encounterTypeId = encounterTypeId;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.reasonForVisit = reasonForVisit;
        this.currentCondition = currentCondition;
        this.modalityId = modalityId;
        this.statusId = statusId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.createdBy = createdBy;
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
        this.updatedBy = updatedBy;
    }

    public static Encounter create(UUID clinicalRecordId, UUID professionalId, UUID encounterTypeId,
                                   LocalDateTime startedAt, String reasonForVisit, UUID modalityId,
                                   UUID statusId, UUID createdBy) {
        LocalDateTime now = LocalDateTime.now();
        return new Encounter(UUID.randomUUID(), clinicalRecordId, professionalId, encounterTypeId,
                startedAt, null, reasonForVisit, null, modalityId, statusId, now, createdBy, now, null);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getClinicalRecordId() { return clinicalRecordId; }
    public void setClinicalRecordId(UUID clinicalRecordId) { this.clinicalRecordId = clinicalRecordId; }
    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }
    public UUID getEncounterTypeId() { return encounterTypeId; }
    public void setEncounterTypeId(UUID encounterTypeId) { this.encounterTypeId = encounterTypeId; }
    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }
    public LocalDateTime getEndedAt() { return endedAt; }
    public void setEndedAt(LocalDateTime endedAt) { this.endedAt = endedAt; }
    public String getReasonForVisit() { return reasonForVisit; }
    public void setReasonForVisit(String reasonForVisit) { this.reasonForVisit = reasonForVisit; }
    public String getCurrentCondition() { return currentCondition; }
    public void setCurrentCondition(String currentCondition) { this.currentCondition = currentCondition; }
    public UUID getModalityId() { return modalityId; }
    public void setModalityId(UUID modalityId) { this.modalityId = modalityId; }
    public UUID getStatusId() { return statusId; }
    public void setStatusId(UUID statusId) { this.statusId = statusId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public UUID getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(UUID updatedBy) { this.updatedBy = updatedBy; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((Encounter) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Encounter{id=" + id + ", clinicalRecordId=" + clinicalRecordId + ", startedAt=" + startedAt + "}";
    }
}

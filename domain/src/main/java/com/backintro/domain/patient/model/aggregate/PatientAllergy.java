package com.backintro.domain.patient.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de alergia del paciente (dentro del agregado Patient).
 */
public class PatientAllergy {

    private UUID id;
    private UUID patientId;
    private String substance;
    private String reaction;
    private String severity;
    private Boolean active;
    private LocalDateTime recordedAt;
    private UUID recordedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PatientAllergy() {}

    public PatientAllergy(UUID id, UUID patientId, String substance, String reaction,
                          String severity, Boolean active, LocalDateTime recordedAt, UUID recordedBy,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.patientId = patientId;
        this.substance = substance;
        this.reaction = reaction;
        this.severity = severity;
        this.active = active;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static PatientAllergy create(UUID patientId, String substance, String reaction,
                                        String severity, UUID recordedBy) {
        LocalDateTime now = LocalDateTime.now();
        return new PatientAllergy(UUID.randomUUID(), patientId, substance, reaction,
                severity, Boolean.TRUE, now, recordedBy, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }
    public String getSubstance() { return substance; }
    public void setSubstance(String substance) { this.substance = substance; }
    public String getReaction() { return reaction; }
    public void setReaction(String reaction) { this.reaction = reaction; }
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
    public UUID getRecordedBy() { return recordedBy; }
    public void setRecordedBy(UUID recordedBy) { this.recordedBy = recordedBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((PatientAllergy) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "PatientAllergy{id=" + id + ", substance='" + substance + "'}";
    }
}

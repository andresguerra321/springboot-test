package com.backintro.domain.clinicalrecord.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Nota clínica SOAP (Subjective, Objective, Assessment, Plan).
 */
public class ClinicalNote {

    private UUID id;
    private UUID encounterId;
    private UUID professionalId;
    private String subjective;
    private String objective;
    private String assessment;
    private String plan;
    private String additionalNotes;
    private LocalDateTime signedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClinicalNote() {}

    public ClinicalNote(UUID id, UUID encounterId, UUID professionalId, String subjective, String objective,
                        String assessment, String plan, String additionalNotes, LocalDateTime signedAt,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.encounterId = encounterId;
        this.professionalId = professionalId;
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ClinicalNote create(UUID encounterId, UUID professionalId) {
        LocalDateTime now = LocalDateTime.now();
        return new ClinicalNote(UUID.randomUUID(), encounterId, professionalId,
                null, null, null, null, null, null, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getEncounterId() { return encounterId; }
    public void setEncounterId(UUID encounterId) { this.encounterId = encounterId; }
    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }
    public String getSubjective() { return subjective; }
    public void setSubjective(String subjective) { this.subjective = subjective; }
    public String getObjective() { return objective; }
    public void setObjective(String objective) { this.objective = objective; }
    public String getAssessment() { return assessment; }
    public void setAssessment(String assessment) { this.assessment = assessment; }
    public String getPlan() { return plan; }
    public void setPlan(String plan) { this.plan = plan; }
    public String getAdditionalNotes() { return additionalNotes; }
    public void setAdditionalNotes(String additionalNotes) { this.additionalNotes = additionalNotes; }
    public LocalDateTime getSignedAt() { return signedAt; }
    public void setSignedAt(LocalDateTime signedAt) { this.signedAt = signedAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((ClinicalNote) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "ClinicalNote{id=" + id + ", encounterId=" + encounterId + "}";
    }
}

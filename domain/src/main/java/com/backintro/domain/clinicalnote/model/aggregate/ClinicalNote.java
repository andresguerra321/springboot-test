package com.backintro.domain.clinicalnote.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.clinicalnote.event.ClinicalNoteRegisteredEvent;
import com.backintro.domain.clinicalnote.event.ClinicalNoteUpdatedEvent;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;

public class ClinicalNote extends AggregateRoot {
    private final ClinicalNoteId id;
    private UUID encounterId;
    private UUID professionalId;
    private String subjective;
    private String objective;
    private String assessment;
    private String plan;
    private String additionalNotes;
    private java.time.LocalDateTime signedAt;

    private ClinicalNote(
        ClinicalNoteId id,
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = Objects.requireNonNull(encounterId, "encounterId must not be null");
        this.professionalId = Objects.requireNonNull(professionalId, "professionalId must not be null");
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
    }

    public static ClinicalNote register(
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt) {

        ClinicalNoteId id = ClinicalNoteId.generate();

        ClinicalNote entity = new ClinicalNote(
            id,
            encounterId,
            professionalId,
            subjective,
            objective,
            assessment,
            plan,
            additionalNotes,
            signedAt);

        entity.recordEvent(
            new ClinicalNoteRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ClinicalNote restore(
        ClinicalNoteId id,
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt) {
        return new ClinicalNote(
            id,
            encounterId,
            professionalId,
            subjective,
            objective,
            assessment,
            plan,
            additionalNotes,
            signedAt);
    }

    public void update(
        UUID encounterId,
        UUID professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        java.time.LocalDateTime signedAt) {

        this.encounterId = Objects.requireNonNull(encounterId);
        this.professionalId = Objects.requireNonNull(professionalId);
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;

        recordEvent(
            new ClinicalNoteUpdatedEvent(
                this.id,
                this.encounterId,
                this.professionalId,
                this.subjective,
                this.objective,
                this.assessment,
                this.plan,
                this.additionalNotes,
                this.signedAt,
                LocalDateTime.now()));
    }

    public ClinicalNoteId id() {
        return id;
    }

    public UUID encounterId() {
        return encounterId;
    }
    public UUID professionalId() {
        return professionalId;
    }
    public String subjective() {
        return subjective;
    }
    public String objective() {
        return objective;
    }
    public String assessment() {
        return assessment;
    }
    public String plan() {
        return plan;
    }
    public String additionalNotes() {
        return additionalNotes;
    }
    public java.time.LocalDateTime signedAt() {
        return signedAt;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ClinicalNoteId getId() {
        return id();
    }

    public UUID getEncounterId() {
        return encounterId();
    }
    public UUID getProfessionalId() {
        return professionalId();
    }
    public String getSubjective() {
        return subjective();
    }
    public String getObjective() {
        return objective();
    }
    public String getAssessment() {
        return assessment();
    }
    public String getPlan() {
        return plan();
    }
    public String getAdditionalNotes() {
        return additionalNotes();
    }
    public java.time.LocalDateTime getSignedAt() {
        return signedAt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalNote that = (ClinicalNote) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClinicalNote{" +
                "id=" + id +
                '}';
    }
}
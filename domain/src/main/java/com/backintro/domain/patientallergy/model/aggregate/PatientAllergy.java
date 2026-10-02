package com.backintro.domain.patientallergy.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.patientallergy.event.PatientAllergyRegisteredEvent;
import com.backintro.domain.patientallergy.event.PatientAllergyUpdatedEvent;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;

public class PatientAllergy extends AggregateRoot {
    private final PatientAllergyId id;
    private UUID patientId;
    private String substance;
    private String reaction;
    private String severity;
    private boolean active;
    private java.time.LocalDateTime recordedAt;
    private UUID recordedBy;

    private PatientAllergy(
        PatientAllergyId id,
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        boolean active,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.substance = Objects.requireNonNull(substance, "substance must not be null");
        this.reaction = reaction;
        this.severity = severity;
        this.active = active;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;
    }

    public static PatientAllergy register(
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy) {

        PatientAllergyId id = PatientAllergyId.generate();

        PatientAllergy entity = new PatientAllergy(
            id,
            patientId,
            substance,
            reaction,
            severity,
            true,
            recordedAt,
            recordedBy);

        entity.recordEvent(
            new PatientAllergyRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static PatientAllergy restore(
        PatientAllergyId id,
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        boolean active,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy) {
        return new PatientAllergy(
            id,
            patientId,
            substance,
            reaction,
            severity,
            active,
            recordedAt,
            recordedBy);
    }

    public void update(
        UUID patientId,
        String substance,
        String reaction,
        String severity,
        java.time.LocalDateTime recordedAt,
        UUID recordedBy) {

        this.patientId = Objects.requireNonNull(patientId);
        this.substance = Objects.requireNonNull(substance);
        this.reaction = reaction;
        this.severity = severity;
        this.recordedAt = recordedAt;
        this.recordedBy = recordedBy;

        recordEvent(
            new PatientAllergyUpdatedEvent(
                this.id,
                this.patientId,
                this.substance,
                this.reaction,
                this.severity,
                this.recordedAt,
                this.recordedBy,
                LocalDateTime.now()));
    }

    public PatientAllergyId id() {
        return id;
    }

    public UUID patientId() {
        return patientId;
    }
    public String substance() {
        return substance;
    }
    public String reaction() {
        return reaction;
    }
    public String severity() {
        return severity;
    }
    public boolean active() {
        return active;
    }
    public java.time.LocalDateTime recordedAt() {
        return recordedAt;
    }
    public UUID recordedBy() {
        return recordedBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public PatientAllergyId getId() {
        return id();
    }

    public UUID getPatientId() {
        return patientId();
    }
    public String getSubstance() {
        return substance();
    }
    public String getReaction() {
        return reaction();
    }
    public String getSeverity() {
        return severity();
    }
    public java.time.LocalDateTime getRecordedAt() {
        return recordedAt();
    }
    public UUID getRecordedBy() {
        return recordedBy();
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientAllergy that = (PatientAllergy) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PatientAllergy{" +
                "id=" + id +
                '}';
    }
}
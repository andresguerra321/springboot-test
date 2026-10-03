package com.backintro.domain.patientcontact.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.patientcontact.event.PatientContactRegisteredEvent;
import com.backintro.domain.patientcontact.event.PatientContactUpdatedEvent;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;

public class PatientContact extends AggregateRoot {
    private final PatientContactId id;
    private UUID contactId;
    private UUID patientId;
    private boolean primaryContact;
    private boolean emergencyContact;
    private UUID relationshipTypeId;

    private PatientContact(
        PatientContactId id,
        UUID contactId,
        UUID patientId,
        boolean primaryContact,
        boolean emergencyContact,
        UUID relationshipTypeId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.patientId = Objects.requireNonNull(patientId, "patientId must not be null");
        this.primaryContact = primaryContact;
        this.emergencyContact = emergencyContact;
        this.relationshipTypeId = relationshipTypeId;
    }

    public static PatientContact register(
        UUID contactId,
        UUID patientId,
        boolean primaryContact,
        boolean emergencyContact,
        UUID relationshipTypeId) {

        PatientContactId id = PatientContactId.generate();

        PatientContact entity = new PatientContact(
            id,
            contactId,
            patientId,
            primaryContact,
            emergencyContact,
            relationshipTypeId);

        entity.recordEvent(
            new PatientContactRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static PatientContact restore(
        PatientContactId id,
        UUID contactId,
        UUID patientId,
        boolean primaryContact,
        boolean emergencyContact,
        UUID relationshipTypeId) {
        return new PatientContact(
            id,
            contactId,
            patientId,
            primaryContact,
            emergencyContact,
            relationshipTypeId);
    }

    public void update(
        UUID contactId,
        UUID patientId,
        boolean primaryContact,
        boolean emergencyContact,
        UUID relationshipTypeId) {

        this.contactId = Objects.requireNonNull(contactId);
        this.patientId = Objects.requireNonNull(patientId);
        this.primaryContact = primaryContact;
        this.emergencyContact = emergencyContact;
        this.relationshipTypeId = relationshipTypeId;

        recordEvent(
            new PatientContactUpdatedEvent(
                this.id,
                this.contactId,
                this.patientId,
                this.primaryContact,
                this.emergencyContact,
                this.relationshipTypeId,
                LocalDateTime.now()));
    }

    public PatientContactId id() {
        return id;
    }

    public UUID contactId() {
        return contactId;
    }
    public UUID patientId() {
        return patientId;
    }
    public boolean primaryContact() {
        return primaryContact;
    }
    public boolean emergencyContact() {
        return emergencyContact;
    }
    public UUID relationshipTypeId() {
        return relationshipTypeId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public PatientContactId getId() {
        return id();
    }

    public UUID getContactId() {
        return contactId();
    }
    public UUID getPatientId() {
        return patientId();
    }
    public boolean isPrimaryContact() {
        return primaryContact();
    }
    public boolean isEmergencyContact() {
        return emergencyContact();
    }
    public UUID getRelationshipTypeId() {
        return relationshipTypeId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContact that = (PatientContact) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PatientContact{" +
                "id=" + id +
                '}';
    }
}
package com.backintro.domain.patient.model.aggregate;

import java.util.Objects;
import java.util.UUID;

/**
 * Entidad que vincula un paciente con un contacto (tabla intermedia patient_contacts).
 */
public class PatientContact {

    private UUID id;
    private UUID contactId;
    private UUID patientId;
    private Boolean isPrimaryContact;
    private Boolean isEmergencyContact;
    private UUID relationshipTypeId;

    public PatientContact() {}

    public PatientContact(UUID id, UUID contactId, UUID patientId, Boolean isPrimaryContact,
                          Boolean isEmergencyContact, UUID relationshipTypeId) {
        this.id = id;
        this.contactId = contactId;
        this.patientId = patientId;
        this.isPrimaryContact = isPrimaryContact;
        this.isEmergencyContact = isEmergencyContact;
        this.relationshipTypeId = relationshipTypeId;
    }

    public static PatientContact create(UUID contactId, UUID patientId, Boolean isPrimary,
                                        Boolean isEmergency, UUID relationshipTypeId) {
        return new PatientContact(UUID.randomUUID(), contactId, patientId, isPrimary, isEmergency, relationshipTypeId);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getContactId() { return contactId; }
    public void setContactId(UUID contactId) { this.contactId = contactId; }
    public UUID getPatientId() { return patientId; }
    public void setPatientId(UUID patientId) { this.patientId = patientId; }
    public Boolean getIsPrimaryContact() { return isPrimaryContact; }
    public void setIsPrimaryContact(Boolean primaryContact) { isPrimaryContact = primaryContact; }
    public Boolean getIsEmergencyContact() { return isEmergencyContact; }
    public void setIsEmergencyContact(Boolean emergencyContact) { isEmergencyContact = emergencyContact; }
    public UUID getRelationshipTypeId() { return relationshipTypeId; }
    public void setRelationshipTypeId(UUID relationshipTypeId) { this.relationshipTypeId = relationshipTypeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((PatientContact) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "PatientContact{id=" + id + ", patientId=" + patientId + ", contactId=" + contactId + "}";
    }
}

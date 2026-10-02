package com.backintro.infrastructure.patientcontact.adapters.out.persistence.entity;

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
@Table(name = "patient_contacts")
public class PatientContactJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "contact_id", nullable = false)
    private UUID contactId;
    @Column(name = "patient_id", nullable = false)
    private UUID patientId;
    @Column(name = "is_primary_contact", nullable = true)
    private boolean primaryContact;
    @Column(name = "is_emergency_contact", nullable = true)
    private boolean emergencyContact;
    @Column(name = "relationship_type_id", nullable = true)
    private UUID relationshipTypeId;

    public PatientContactJpaEntity() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getContactId() {
        return contactId;
    }
    public void setContactId(UUID contactId) {
        this.contactId = contactId;
    }
    public UUID getPatientId() {
        return patientId;
    }
    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }
    public boolean isPrimaryContact() {
        return primaryContact;
    }
    public void setPrimaryContact(boolean primaryContact) {
        this.primaryContact = primaryContact;
    }
    public boolean isEmergencyContact() {
        return emergencyContact;
    }
    public void setEmergencyContact(boolean emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    public UUID getRelationshipTypeId() {
        return relationshipTypeId;
    }
    public void setRelationshipTypeId(UUID relationshipTypeId) {
        this.relationshipTypeId = relationshipTypeId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientContactJpaEntity that = (PatientContactJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
package com.backintro.domain.patient.model.aggregate;

import com.backintro.domain.patient.model.valueobject.DocumentNumber;
import com.backintro.domain.patient.model.valueobject.PersonName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Paciente.
 * POJO puro sin anotaciones de frameworks.
 */
public class Patient {

    private UUID id;
    private UUID documentTypeId;
    private DocumentNumber documentNumber;
    private PersonName personName;
    private LocalDate birthDate;
    private UUID biologicalSexId;
    private UUID genderIdentityId;
    private String email;
    private String phone;
    private String address;
    private Boolean active;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;
    private UUID cityId;

    public Patient() {}

    public Patient(UUID id, UUID documentTypeId, DocumentNumber documentNumber, PersonName personName,
                   LocalDate birthDate, UUID biologicalSexId, UUID genderIdentityId,
                   String email, String phone, String address, Boolean active,
                   LocalDateTime createdAt, UUID createdBy, LocalDateTime updatedAt, UUID updatedBy, UUID cityId) {
        this.id = id;
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.personName = personName;
        this.birthDate = birthDate;
        this.biologicalSexId = biologicalSexId;
        this.genderIdentityId = genderIdentityId;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = active != null ? active : Boolean.TRUE;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.createdBy = createdBy;
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
        this.updatedBy = updatedBy;
        this.cityId = cityId;
    }

    public static Patient create(UUID documentTypeId, String documentNumber,
                                 String firstName, String middleName, String lastName, String secondLastName,
                                 LocalDate birthDate, UUID biologicalSexId, UUID genderIdentityId,
                                 String email, String phone, String address, UUID cityId, UUID createdBy) {
        LocalDateTime now = LocalDateTime.now();
        return new Patient(UUID.randomUUID(), documentTypeId,
                new DocumentNumber(documentNumber),
                new PersonName(firstName, middleName, lastName, secondLastName),
                birthDate, biologicalSexId, genderIdentityId,
                email, phone, address, Boolean.TRUE, now, createdBy, now, null, cityId);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getDocumentTypeId() { return documentTypeId; }
    public void setDocumentTypeId(UUID documentTypeId) { this.documentTypeId = documentTypeId; }
    public DocumentNumber getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(DocumentNumber documentNumber) { this.documentNumber = documentNumber; }
    public PersonName getPersonName() { return personName; }
    public void setPersonName(PersonName personName) { this.personName = personName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public UUID getBiologicalSexId() { return biologicalSexId; }
    public void setBiologicalSexId(UUID biologicalSexId) { this.biologicalSexId = biologicalSexId; }
    public UUID getGenderIdentityId() { return genderIdentityId; }
    public void setGenderIdentityId(UUID genderIdentityId) { this.genderIdentityId = genderIdentityId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public UUID getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(UUID updatedBy) { this.updatedBy = updatedBy; }
    public UUID getCityId() { return cityId; }
    public void setCityId(UUID cityId) { this.cityId = cityId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((Patient) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Patient{id=" + id + ", documentNumber=" + documentNumber + ", name=" + personName + "}";
    }
}

package com.backintro.domain.patient.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.patient.event.PatientRegisteredEvent;
import com.backintro.domain.patient.event.PatientUpdatedEvent;
import com.backintro.domain.patient.model.valueobject.PatientId;

public class Patient extends AggregateRoot {
    private final PatientId id;
    private UUID documentTypeId;
    private String documentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private java.time.LocalDate birthDate;
    private UUID biologicalSexId;
    private UUID genderIdentity;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private UUID cityId;
    private UUID createdBy;
    private UUID updatedBy;

    private Patient(
        PatientId id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        java.time.LocalDate birthDate,
        UUID biologicalSexId,
        UUID genderIdentity,
        String email,
        String phone,
        String address,
        boolean active,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        this.documentNumber = Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        this.firstName = Objects.requireNonNull(firstName, "firstName must not be null");
        this.middleName = middleName;
        this.lastName = Objects.requireNonNull(lastName, "lastName must not be null");
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = Objects.requireNonNull(biologicalSexId, "biologicalSexId must not be null");
        this.genderIdentity = genderIdentity;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.cityId = cityId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public static Patient register(
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        java.time.LocalDate birthDate,
        UUID biologicalSexId,
        UUID genderIdentity,
        String email,
        String phone,
        String address,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {

        PatientId id = PatientId.generate();

        Patient entity = new Patient(
            id,
            documentTypeId,
            documentNumber,
            firstName,
            middleName,
            lastName,
            secondLastName,
            birthDate,
            biologicalSexId,
            genderIdentity,
            email,
            phone,
            address,
            true,
            cityId,
            createdBy,
            updatedBy);

        entity.recordEvent(
            new PatientRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Patient restore(
        PatientId id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        java.time.LocalDate birthDate,
        UUID biologicalSexId,
        UUID genderIdentity,
        String email,
        String phone,
        String address,
        boolean active,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {
        return new Patient(
            id,
            documentTypeId,
            documentNumber,
            firstName,
            middleName,
            lastName,
            secondLastName,
            birthDate,
            biologicalSexId,
            genderIdentity,
            email,
            phone,
            address,
            active,
            cityId,
            createdBy,
            updatedBy);
    }

    public void update(
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        java.time.LocalDate birthDate,
        UUID biologicalSexId,
        UUID genderIdentity,
        String email,
        String phone,
        String address,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {

        this.documentTypeId = Objects.requireNonNull(documentTypeId);
        this.documentNumber = Objects.requireNonNull(documentNumber);
        this.firstName = Objects.requireNonNull(firstName);
        this.middleName = middleName;
        this.lastName = Objects.requireNonNull(lastName);
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = Objects.requireNonNull(biologicalSexId);
        this.genderIdentity = genderIdentity;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.cityId = cityId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;

        recordEvent(
            new PatientUpdatedEvent(
                this.id,
                this.documentTypeId,
                this.documentNumber,
                this.firstName,
                this.middleName,
                this.lastName,
                this.secondLastName,
                this.birthDate,
                this.biologicalSexId,
                this.genderIdentity,
                this.email,
                this.phone,
                this.address,
                this.cityId,
                this.createdBy,
                this.updatedBy,
                LocalDateTime.now()));
    }

    public PatientId id() {
        return id;
    }

    public UUID documentTypeId() {
        return documentTypeId;
    }
    public String documentNumber() {
        return documentNumber;
    }
    public String firstName() {
        return firstName;
    }
    public String middleName() {
        return middleName;
    }
    public String lastName() {
        return lastName;
    }
    public String secondLastName() {
        return secondLastName;
    }
    public java.time.LocalDate birthDate() {
        return birthDate;
    }
    public UUID biologicalSexId() {
        return biologicalSexId;
    }
    public UUID genderIdentity() {
        return genderIdentity;
    }
    public String email() {
        return email;
    }
    public String phone() {
        return phone;
    }
    public String address() {
        return address;
    }
    public boolean active() {
        return active;
    }
    public UUID cityId() {
        return cityId;
    }
    public UUID createdBy() {
        return createdBy;
    }
    public UUID updatedBy() {
        return updatedBy;
    }
    // Alias para compatibilidad con mappers y frameworks
    public PatientId getId() {
        return id();
    }

    public UUID getDocumentTypeId() {
        return documentTypeId();
    }
    public String getDocumentNumber() {
        return documentNumber();
    }
    public String getFirstName() {
        return firstName();
    }
    public String getMiddleName() {
        return middleName();
    }
    public String getLastName() {
        return lastName();
    }
    public String getSecondLastName() {
        return secondLastName();
    }
    public java.time.LocalDate getBirthDate() {
        return birthDate();
    }
    public UUID getBiologicalSexId() {
        return biologicalSexId();
    }
    public UUID getGenderIdentity() {
        return genderIdentity();
    }
    public String getEmail() {
        return email();
    }
    public String getPhone() {
        return phone();
    }
    public String getAddress() {
        return address();
    }
    public UUID getCityId() {
        return cityId();
    }
    public UUID getCreatedBy() {
        return createdBy();
    }
    public UUID getUpdatedBy() {
        return updatedBy();
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
        Patient that = (Patient) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                '}';
    }
}
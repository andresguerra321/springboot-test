package com.backintro.infrastructure.patient.adapters.out.persistence.entity;

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
@Table(name = "patients")
public class PatientJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "document_type_id", nullable = false)
    private UUID documentTypeId;
    @Column(name = "document_number", nullable = false, length = 30)
    private String documentNumber;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "middle_name", nullable = true, length = 50)
    private String middleName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "second_last_name", nullable = true, length = 50)
    private String secondLastName;
    @Column(name = "birth_date", nullable = true)
    private java.time.LocalDate birthDate;
    @Column(name = "biological_sex_id", nullable = false)
    private UUID biologicalSexId;
    @Column(name = "gender_identity", nullable = true)
    private UUID genderIdentity;
    @Column(name = "email", nullable = true, length = 150)
    private String email;
    @Column(name = "phone", nullable = true, length = 30)
    private String phone;
    @Column(name = "address", nullable = true, length = 250)
    private String address;
    @Column(name = "active", nullable = false)
    private boolean active;
    @Column(name = "city_id", nullable = true)
    private UUID cityId;
    @Column(name = "created_by", nullable = true)
    private UUID createdBy;
    @Column(name = "updated_by", nullable = true)
    private UUID updatedBy;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public PatientJpaEntity() {}

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) this.createdAt = LocalDateTime.now();
        if (this.updatedAt == null) this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getDocumentTypeId() {
        return documentTypeId;
    }
    public void setDocumentTypeId(UUID documentTypeId) {
        this.documentTypeId = documentTypeId;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSecondLastName() {
        return secondLastName;
    }
    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }
    public java.time.LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(java.time.LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public UUID getBiologicalSexId() {
        return biologicalSexId;
    }
    public void setBiologicalSexId(UUID biologicalSexId) {
        this.biologicalSexId = biologicalSexId;
    }
    public UUID getGenderIdentity() {
        return genderIdentity;
    }
    public void setGenderIdentity(UUID genderIdentity) {
        this.genderIdentity = genderIdentity;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public UUID getCityId() {
        return cityId;
    }
    public void setCityId(UUID cityId) {
        this.cityId = cityId;
    }
    public UUID getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(UUID createdBy) {
        this.createdBy = createdBy;
    }
    public UUID getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(UUID updatedBy) {
        this.updatedBy = updatedBy;
    }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientJpaEntity that = (PatientJpaEntity) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
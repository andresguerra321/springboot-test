package com.backintro.domain.professional.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Profesional de salud.
 * POJO puro sin anotaciones de frameworks.
 */
public class Professional {

    private UUID id;
    private UUID documentTypeId;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private UUID professionalTypeId;
    private String licenseNumber;
    private Boolean active;
    private UUID cityId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Professional() {}

    public Professional(UUID id, UUID documentTypeId, String documentNumber, String firstName, String lastName,
                        UUID professionalTypeId, String licenseNumber, Boolean active, UUID cityId,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.professionalTypeId = professionalTypeId;
        this.licenseNumber = licenseNumber;
        this.active = active != null ? active : Boolean.TRUE;
        this.cityId = cityId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static Professional create(UUID documentTypeId, String documentNumber, String firstName, String lastName,
                                      UUID professionalTypeId, String licenseNumber, UUID cityId) {
        LocalDateTime now = LocalDateTime.now();
        return new Professional(UUID.randomUUID(), documentTypeId, documentNumber, firstName, lastName,
                professionalTypeId, licenseNumber, Boolean.TRUE, cityId, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getDocumentTypeId() { return documentTypeId; }
    public void setDocumentTypeId(UUID documentTypeId) { this.documentTypeId = documentTypeId; }
    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public UUID getProfessionalTypeId() { return professionalTypeId; }
    public void setProfessionalTypeId(UUID professionalTypeId) { this.professionalTypeId = professionalTypeId; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public UUID getCityId() { return cityId; }
    public void setCityId(UUID cityId) { this.cityId = cityId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((Professional) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Professional{id=" + id + ", firstName='" + firstName + "', lastName='" + lastName + "'}";
    }
}

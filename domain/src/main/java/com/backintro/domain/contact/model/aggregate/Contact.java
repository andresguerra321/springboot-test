package com.backintro.domain.contact.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Contacto.
 */
public class Contact {

    private UUID id;
    private String fullName;
    private String email;
    private String notes;
    private UUID cityId;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;

    public Contact() {}

    public Contact(UUID id, String fullName, String email, String notes, UUID cityId,
                   LocalDateTime createdAt, UUID createdBy, LocalDateTime updatedAt, UUID updatedBy) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.notes = notes;
        this.cityId = cityId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.createdBy = createdBy;
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
        this.updatedBy = updatedBy;
    }

    public static Contact create(String fullName, String email, String notes, UUID cityId, UUID createdBy) {
        LocalDateTime now = LocalDateTime.now();
        return new Contact(UUID.randomUUID(), fullName, email, notes, cityId, now, createdBy, now, null);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public UUID getCityId() { return cityId; }
    public void setCityId(UUID cityId) { this.cityId = cityId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public UUID getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(UUID updatedBy) { this.updatedBy = updatedBy; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((Contact) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "Contact{id=" + id + ", fullName='" + fullName + "'}";
    }
}

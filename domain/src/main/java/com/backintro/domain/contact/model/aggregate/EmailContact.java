package com.backintro.domain.contact.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de email de contacto (dentro del agregado Contact).
 */
public class EmailContact {

    private UUID id;
    private UUID contactId;
    private String email;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EmailContact() {}

    public EmailContact(UUID id, UUID contactId, String email, String notes,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.contactId = contactId;
        this.email = email;
        this.notes = notes;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static EmailContact create(UUID contactId, String email, String notes) {
        LocalDateTime now = LocalDateTime.now();
        return new EmailContact(UUID.randomUUID(), contactId, email, notes, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getContactId() { return contactId; }
    public void setContactId(UUID contactId) { this.contactId = contactId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((EmailContact) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "EmailContact{id=" + id + ", email='" + email + "'}";
    }
}

package com.backintro.domain.contact.model.aggregate;

import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de teléfono de contacto (dentro del agregado Contact).
 */
public class PhoneContact {

    private UUID id;
    private UUID contactId;
    private String phone;
    private String notes;

    public PhoneContact() {}

    public PhoneContact(UUID id, UUID contactId, String phone, String notes) {
        this.id = id;
        this.contactId = contactId;
        this.phone = phone;
        this.notes = notes;
    }

    public static PhoneContact create(UUID contactId, String phone, String notes) {
        return new PhoneContact(UUID.randomUUID(), contactId, phone, notes);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getContactId() { return contactId; }
    public void setContactId(UUID contactId) { this.contactId = contactId; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((PhoneContact) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "PhoneContact{id=" + id + ", phone='" + phone + "'}";
    }
}

package com.backintro.domain.phonecontact.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.phonecontact.event.PhoneContactRegisteredEvent;
import com.backintro.domain.phonecontact.event.PhoneContactUpdatedEvent;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;

public class PhoneContact extends AggregateRoot {
    private final PhoneContactId id;
    private UUID contactId;
    private String phone;
    private String notes;

    private PhoneContact(
        PhoneContactId id,
        UUID contactId,
        String phone,
        String notes) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.phone = Objects.requireNonNull(phone, "phone must not be null");
        this.notes = notes;
    }

    public static PhoneContact register(
        UUID contactId,
        String phone,
        String notes) {

        PhoneContactId id = PhoneContactId.generate();

        PhoneContact entity = new PhoneContact(
            id,
            contactId,
            phone,
            notes);

        entity.recordEvent(
            new PhoneContactRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static PhoneContact restore(
        PhoneContactId id,
        UUID contactId,
        String phone,
        String notes) {
        return new PhoneContact(
            id,
            contactId,
            phone,
            notes);
    }

    public void update(
        UUID contactId,
        String phone,
        String notes) {

        this.contactId = Objects.requireNonNull(contactId);
        this.phone = Objects.requireNonNull(phone);
        this.notes = notes;

        recordEvent(
            new PhoneContactUpdatedEvent(
                this.id,
                this.contactId,
                this.phone,
                this.notes,
                LocalDateTime.now()));
    }

    public PhoneContactId id() {
        return id;
    }

    public UUID contactId() {
        return contactId;
    }
    public String phone() {
        return phone;
    }
    public String notes() {
        return notes;
    }
    // Alias para compatibilidad con mappers y frameworks
    public PhoneContactId getId() {
        return id();
    }

    public UUID getContactId() {
        return contactId();
    }
    public String getPhone() {
        return phone();
    }
    public String getNotes() {
        return notes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneContact that = (PhoneContact) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PhoneContact{" +
                "id=" + id +
                '}';
    }
}
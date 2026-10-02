package com.backintro.domain.emailcontact.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.emailcontact.event.EmailContactRegisteredEvent;
import com.backintro.domain.emailcontact.event.EmailContactUpdatedEvent;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public class EmailContact extends AggregateRoot {
    private final EmailContactId id;
    private UUID contactId;
    private String email;
    private String notes;

    private EmailContact(
        EmailContactId id,
        UUID contactId,
        String email,
        String notes) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.contactId = Objects.requireNonNull(contactId, "contactId must not be null");
        this.email = Objects.requireNonNull(email, "email must not be null");
        this.notes = notes;
    }

    public static EmailContact register(
        UUID contactId,
        String email,
        String notes) {

        EmailContactId id = EmailContactId.generate();

        EmailContact entity = new EmailContact(
            id,
            contactId,
            email,
            notes);

        entity.recordEvent(
            new EmailContactRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static EmailContact restore(
        EmailContactId id,
        UUID contactId,
        String email,
        String notes) {
        return new EmailContact(
            id,
            contactId,
            email,
            notes);
    }

    public void update(
        UUID contactId,
        String email,
        String notes) {

        this.contactId = Objects.requireNonNull(contactId);
        this.email = Objects.requireNonNull(email);
        this.notes = notes;

        recordEvent(
            new EmailContactUpdatedEvent(
                this.id,
                this.contactId,
                this.email,
                this.notes,
                LocalDateTime.now()));
    }

    public EmailContactId id() {
        return id;
    }

    public UUID contactId() {
        return contactId;
    }
    public String email() {
        return email;
    }
    public String notes() {
        return notes;
    }
    // Alias para compatibilidad con mappers y frameworks
    public EmailContactId getId() {
        return id();
    }

    public UUID getContactId() {
        return contactId();
    }
    public String getEmail() {
        return email();
    }
    public String getNotes() {
        return notes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailContact that = (EmailContact) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EmailContact{" +
                "id=" + id +
                '}';
    }
}
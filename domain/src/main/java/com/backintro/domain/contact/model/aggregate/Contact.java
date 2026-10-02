package com.backintro.domain.contact.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.contact.event.ContactRegisteredEvent;
import com.backintro.domain.contact.event.ContactUpdatedEvent;
import com.backintro.domain.contact.model.valueobject.ContactId;

public class Contact extends AggregateRoot {
    private final ContactId id;
    private String fullName;
    private String email;
    private String notes;
    private UUID cityId;
    private UUID createdBy;
    private UUID updatedBy;

    private Contact(
        ContactId id,
        String fullName,
        String email,
        String notes,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.fullName = Objects.requireNonNull(fullName, "fullName must not be null");
        this.email = email;
        this.notes = notes;
        this.cityId = cityId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public static Contact register(
        String fullName,
        String email,
        String notes,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {

        ContactId id = ContactId.generate();

        Contact entity = new Contact(
            id,
            fullName,
            email,
            notes,
            cityId,
            createdBy,
            updatedBy);

        entity.recordEvent(
            new ContactRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Contact restore(
        ContactId id,
        String fullName,
        String email,
        String notes,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {
        return new Contact(
            id,
            fullName,
            email,
            notes,
            cityId,
            createdBy,
            updatedBy);
    }

    public void update(
        String fullName,
        String email,
        String notes,
        UUID cityId,
        UUID createdBy,
        UUID updatedBy) {

        this.fullName = Objects.requireNonNull(fullName);
        this.email = email;
        this.notes = notes;
        this.cityId = cityId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;

        recordEvent(
            new ContactUpdatedEvent(
                this.id,
                this.fullName,
                this.email,
                this.notes,
                this.cityId,
                this.createdBy,
                this.updatedBy,
                LocalDateTime.now()));
    }

    public ContactId id() {
        return id;
    }

    public String fullName() {
        return fullName;
    }
    public String email() {
        return email;
    }
    public String notes() {
        return notes;
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
    public ContactId getId() {
        return id();
    }

    public String getFullName() {
        return fullName();
    }
    public String getEmail() {
        return email();
    }
    public String getNotes() {
        return notes();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact that = (Contact) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                '}';
    }
}
package com.backintro.domain.professional.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.professional.event.ProfessionalRegisteredEvent;
import com.backintro.domain.professional.event.ProfessionalUpdatedEvent;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;

public class Professional extends AggregateRoot {
    private final ProfessionalId id;
    private UUID documentTypeId;
    private String documentNumber;
    private String firstName;
    private String lastName;
    private UUID professionalTypeId;
    private String licenseNumber;
    private UUID cityId;
    private boolean active;

    private Professional(
        ProfessionalId id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String licenseNumber,
        UUID cityId,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.documentTypeId = Objects.requireNonNull(documentTypeId, "documentTypeId must not be null");
        this.documentNumber = Objects.requireNonNull(documentNumber, "documentNumber must not be null");
        this.firstName = Objects.requireNonNull(firstName, "firstName must not be null");
        this.lastName = Objects.requireNonNull(lastName, "lastName must not be null");
        this.professionalTypeId = Objects.requireNonNull(professionalTypeId, "professionalTypeId must not be null");
        this.licenseNumber = licenseNumber;
        this.cityId = cityId;
        this.active = active;
    }

    public static Professional register(
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String licenseNumber,
        UUID cityId) {

        ProfessionalId id = ProfessionalId.generate();

        Professional entity = new Professional(
            id,
            documentTypeId,
            documentNumber,
            firstName,
            lastName,
            professionalTypeId,
            licenseNumber,
            cityId,
            true);

        entity.recordEvent(
            new ProfessionalRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Professional restore(
        ProfessionalId id,
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String licenseNumber,
        UUID cityId,
        boolean active) {
        return new Professional(
            id,
            documentTypeId,
            documentNumber,
            firstName,
            lastName,
            professionalTypeId,
            licenseNumber,
            cityId,
            active);
    }

    public void update(
        UUID documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        UUID professionalTypeId,
        String licenseNumber,
        UUID cityId) {

        this.documentTypeId = Objects.requireNonNull(documentTypeId);
        this.documentNumber = Objects.requireNonNull(documentNumber);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.professionalTypeId = Objects.requireNonNull(professionalTypeId);
        this.licenseNumber = licenseNumber;
        this.cityId = cityId;

        recordEvent(
            new ProfessionalUpdatedEvent(
                this.id,
                this.documentTypeId,
                this.documentNumber,
                this.firstName,
                this.lastName,
                this.professionalTypeId,
                this.licenseNumber,
                this.cityId,
                LocalDateTime.now()));
    }

    public ProfessionalId id() {
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
    public String lastName() {
        return lastName;
    }
    public UUID professionalTypeId() {
        return professionalTypeId;
    }
    public String licenseNumber() {
        return licenseNumber;
    }
    public UUID cityId() {
        return cityId;
    }
    public boolean active() {
        return active;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ProfessionalId getId() {
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
    public String getLastName() {
        return lastName();
    }
    public UUID getProfessionalTypeId() {
        return professionalTypeId();
    }
    public String getLicenseNumber() {
        return licenseNumber();
    }
    public UUID getCityId() {
        return cityId();
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
        Professional that = (Professional) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Professional{" +
                "id=" + id +
                '}';
    }
}
package com.backintro.domain.country.model.aggregate;

import com.backintro.domain.country.model.valueobject.CountryCode;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz de Country en la capa de Dominio.
 * POJO puro e independiente sin anotaciones de frameworks.
 */
public class Country extends com.backintro.domain.common.model.AggregateRoot {

    private UUID id;
    private String nameCountry;
    private CountryCode codeCountry;
    private String description;
    private Boolean isActive;
    private String telephonePrefix;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Country() {
    }

    public Country(UUID id, String nameCountry, CountryCode codeCountry, String description,
                   Boolean isActive, String telephonePrefix, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.isActive = isActive != null ? isActive : Boolean.TRUE;
        this.telephonePrefix = telephonePrefix;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public Country(com.backintro.domain.country.model.valueobject.CountryId countryId, String nameCountry,
                   CountryCode codeCountry, String description, Boolean isActive, String telephonePrefix,
                   LocalDateTime createdAt, LocalDateTime updatedAt) {
        this(countryId != null ? countryId.value() : null, nameCountry, codeCountry, description, isActive, telephonePrefix, createdAt, updatedAt);
    }

    public static Country create(String nameCountry, String codeCountry, String description, String telephonePrefix) {
        LocalDateTime now = LocalDateTime.now();
        Country country = new Country(
                UUID.randomUUID(),
                nameCountry,
                new CountryCode(codeCountry),
                description,
                Boolean.TRUE,
                telephonePrefix,
                now,
                now
        );
        country.registerEvent(new com.backintro.domain.country.event.CountryRegisteredEvent(country.getCountryId(), now));
        return country;
    }

    public void update(String nameCountry, String codeCountry, String description, String telephonePrefix, Boolean isActive) {
        if (nameCountry != null && !nameCountry.trim().isEmpty()) {
            this.nameCountry = nameCountry;
        }
        if (codeCountry != null && !codeCountry.trim().isEmpty()) {
            this.codeCountry = new CountryCode(codeCountry);
        }
        if (description != null) {
            this.description = description;
        }
        if (telephonePrefix != null) {
            this.telephonePrefix = telephonePrefix;
        }
        if (isActive != null) {
            this.isActive = isActive;
        }
        this.updatedAt = LocalDateTime.now();
        registerEvent(new com.backintro.domain.country.event.CountryUpdatedEvent(this.getCountryId(), this.updatedAt));
    }

    public void delete() {
        registerEvent(new com.backintro.domain.country.event.CountryDeletedEvent(this.getCountryId(), LocalDateTime.now()));
    }

    public com.backintro.domain.country.model.valueobject.CountryId getCountryId() {
        return id != null ? new com.backintro.domain.country.model.valueobject.CountryId(id) : null;
    }

    public void setCountryId(com.backintro.domain.country.model.valueobject.CountryId countryId) {
        this.id = countryId != null ? countryId.value() : null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public CountryCode getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(CountryCode codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getTelephonePrefix() {
        return telephonePrefix;
    }

    public void setTelephonePrefix(String telephonePrefix) {
        this.telephonePrefix = telephonePrefix;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", nameCountry='" + nameCountry + '\'' +
                ", codeCountry=" + codeCountry +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", telephonePrefix='" + telephonePrefix + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

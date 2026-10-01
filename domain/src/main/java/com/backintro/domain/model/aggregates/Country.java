package com.backintro.domain.model.aggregates;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de dominio pura para País (Country).
 * No contiene dependencias ni anotaciones de frameworks de persistencia (JPA, Hibernate, Lombok).
 */
public class Country {

    private UUID id;
    private String nameCountry;
    private String codeCountry;
    private String description;
    private Boolean isActive;
    private String telephonePrefix;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Country() {
    }

    public Country(UUID id, String nameCountry, String codeCountry, String description,
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

    /**
     * Constructor de fábrica para crear nuevos países desde la lógica de negocio.
     */
    public static Country create(String nameCountry, String codeCountry, String description, String telephonePrefix) {
        LocalDateTime now = LocalDateTime.now();
        return new Country(
                UUID.randomUUID(),
                nameCountry,
                codeCountry,
                description,
                Boolean.TRUE,
                telephonePrefix,
                now,
                now
        );
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

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
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

    public void activate() {
        this.isActive = true;
        this.updatedAt = LocalDateTime.now();
    }

    public void deactivate() {
        this.isActive = false;
        this.updatedAt = LocalDateTime.now();
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
                ", codeCountry='" + codeCountry + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                ", telephonePrefix='" + telephonePrefix + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

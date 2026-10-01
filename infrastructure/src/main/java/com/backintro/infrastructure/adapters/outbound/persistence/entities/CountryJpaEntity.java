package com.backintro.infrastructure.adapters.outbound.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad JPA para la tabla 'countries'.
 * Mapeo directo respetando los tipos de datos y restricciones definidos en schema.sql.
 */
@Entity
@Table(name = "countries")
public class CountryJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name_country", length = 50, nullable = false)
    private String nameCountry;

    @Column(name = "code_country", length = 10)
    private String codeCountry;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "telephone_prefix", length = 5)
    private String telephonePrefix;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public CountryJpaEntity() {
    }

    public CountryJpaEntity(UUID id, String nameCountry, String codeCountry, String description,
                            Boolean isActive, String telephonePrefix, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.isActive = isActive;
        this.telephonePrefix = telephonePrefix;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryJpaEntity that = (CountryJpaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CountryJpaEntity{" +
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

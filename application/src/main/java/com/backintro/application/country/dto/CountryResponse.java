package com.backintro.application.country.dto;

import com.backintro.domain.country.model.aggregate.Country;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO de respuesta para la entidad Country.
 */
public class CountryResponse {

    private UUID id;
    private String nameCountry;
    private String codeCountry;
    private String description;
    private Boolean isActive;
    private String telephonePrefix;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CountryResponse() {
    }

    public CountryResponse(UUID id, String nameCountry, String codeCountry, String description,
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

    /**
     * Mapea un agregado de dominio Country hacia CountryResponse.
     */
    public static CountryResponse fromDomain(Country country) {
        if (country == null) {
            return null;
        }

        String code = country.getCodeCountry() != null ? country.getCodeCountry().getValue() : null;

        return new CountryResponse(
                country.getId(),
                country.getNameCountry(),
                code,
                country.getDescription(),
                country.getIsActive(),
                country.getTelephonePrefix(),
                country.getCreatedAt(),
                country.getUpdatedAt()
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

    @Override
    public String toString() {
        return "CountryResponse{" +
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

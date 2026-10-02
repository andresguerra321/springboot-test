package com.backintro.application.country.dto;

import com.backintro.domain.country.model.aggregate.Country;

import java.util.UUID;

/**
 * DTO de respuesta para la entidad Country.
 */
public class CountryResponse {

    private UUID id;
    private String name;
    private String code;
    private Boolean active;

    public CountryResponse() {
    }

    public CountryResponse(UUID id, String name, String code, Boolean active) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.active = active;
    }

    /**
     * Mapea un agregado de dominio Country hacia CountryResponse.
     */
    public static CountryResponse fromDomain(Country country) {
        if (country == null) {
            return null;
        }

        UUID idValue = country.getId() != null ? country.getId().value() : null;

        return new CountryResponse(
                idValue,
                country.getName(),
                country.getCode(),
                country.isActive()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CountryResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", active=" + active +
                '}';
    }
}

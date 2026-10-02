package com.backintro.infrastructure.country.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la petición HTTP de registro de País.
 */
public class RegisterCountryRequest {

    @NotBlank(message = "El nombre del país es obligatorio")
    @Size(max = 50, message = "El nombre del país no puede superar 50 caracteres")
    private String nameCountry;

    @Size(max = 10, message = "El código del país no puede superar 10 caracteres")
    private String codeCountry;

    @Size(max = 100, message = "La descripción no puede superar 100 caracteres")
    private String description;

    @Size(max = 5, message = "El prefijo telefónico no puede superar 5 caracteres")
    private String telephonePrefix;

    public RegisterCountryRequest() {
    }

    public RegisterCountryRequest(String nameCountry, String codeCountry, String description, String telephonePrefix) {
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.telephonePrefix = telephonePrefix;
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

    public String getTelephonePrefix() {
        return telephonePrefix;
    }

    public void setTelephonePrefix(String telephonePrefix) {
        this.telephonePrefix = telephonePrefix;
    }
}

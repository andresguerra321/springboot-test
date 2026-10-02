package com.backintro.application.country.command;

import java.util.UUID;

/**
 * Comando para actualizar un País existente.
 */
public class UpdateCountryCommand {

    private UUID id;
    private String nameCountry;
    private String codeCountry;
    private String description;
    private String telephonePrefix;
    private Boolean isActive;

    public UpdateCountryCommand() {
    }

    public UpdateCountryCommand(UUID id, String nameCountry, String codeCountry,
                                String description, String telephonePrefix, Boolean isActive) {
        this.id = id;
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.telephonePrefix = telephonePrefix;
        this.isActive = isActive;
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

    public String getTelephonePrefix() {
        return telephonePrefix;
    }

    public void setTelephonePrefix(String telephonePrefix) {
        this.telephonePrefix = telephonePrefix;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}

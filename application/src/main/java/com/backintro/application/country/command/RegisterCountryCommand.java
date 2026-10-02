package com.backintro.application.country.command;

/**
 * Comando para registrar un nuevo País.
 */
public class RegisterCountryCommand {

    private String nameCountry;
    private String codeCountry;
    private String description;
    private String telephonePrefix;

    public RegisterCountryCommand() {
    }

    public RegisterCountryCommand(String nameCountry, String codeCountry, String description, String telephonePrefix) {
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

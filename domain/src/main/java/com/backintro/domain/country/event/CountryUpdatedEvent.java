package com.backintro.domain.country.event;

import com.backintro.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Evento de dominio emitido cuando un País es actualizado.
 */
public class CountryUpdatedEvent implements DomainEvent {

    private final UUID countryId;
    private final String nameCountry;
    private final String codeCountry;
    private final LocalDateTime occurredOn;

    public CountryUpdatedEvent(UUID countryId, String nameCountry, String codeCountry) {
        this.countryId = countryId;
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.occurredOn = LocalDateTime.now();
    }

    public UUID getCountryId() {
        return countryId;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    @Override
    public String toString() {
        return "CountryUpdatedEvent{" +
                "countryId=" + countryId +
                ", nameCountry='" + nameCountry + '\'' +
                ", codeCountry='" + codeCountry + '\'' +
                ", occurredOn=" + occurredOn +
                '}';
    }
}

package com.backintro.domain.country.event;

import com.backintro.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Evento de dominio emitido cuando un País es eliminado.
 */
public class CountryDeletedEvent implements DomainEvent {

    private final UUID countryId;
    private final LocalDateTime occurredOn;

    public CountryDeletedEvent(UUID countryId) {
        this.countryId = countryId;
        this.occurredOn = LocalDateTime.now();
    }

    public UUID getCountryId() {
        return countryId;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    @Override
    public String toString() {
        return "CountryDeletedEvent{" +
                "countryId=" + countryId +
                ", occurredOn=" + occurredOn +
                '}';
    }
}

package com.backintro.domain.common.event;

import java.time.LocalDateTime;

/**
 * Interfaz base para todos los eventos del dominio.
 */
public interface DomainEvent {

    /**
     * Fecha y hora en la que ocurrió el evento de dominio.
     *
     * @return Marca temporal del evento.
     */
    LocalDateTime occurredOn();
}

package com.backintro.domain.empresa.event;

import com.backintro.domain.common.event.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Evento de dominio emitido cuando una Empresa es registrada en el sistema.
 */
public class EmpresaRegisteredEvent implements DomainEvent {

    private final UUID empresaId;
    private final String nombre;
    private final String nit;
    private final LocalDateTime occurredOn;

    public EmpresaRegisteredEvent(UUID empresaId, String nombre, String nit) {
        this.empresaId = empresaId;
        this.nombre = nombre;
        this.nit = nit;
        this.occurredOn = LocalDateTime.now();
    }

    public UUID getEmpresaId() {
        return empresaId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    @Override
    public String toString() {
        return "EmpresaRegisteredEvent{" +
                "empresaId=" + empresaId +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", occurredOn=" + occurredOn +
                '}';
    }
}

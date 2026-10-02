package com.backintro.domain.common.model;

import com.backintro.domain.common.event.DomainEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase base para Aggregates del dominio.
 * Maneja el registro y despacho de eventos de dominio (Domain Events).
 */
public abstract class AggregateRoot {

    private final List<DomainEvent> domainEvents = new ArrayList<>();

    protected void registerEvent(DomainEvent event) {
        if (event != null) {
            domainEvents.add(event);
        }
    }

    protected void record(DomainEvent event) {
        registerEvent(event);
    }

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> recordedEvents = new ArrayList<>(this.domainEvents);
        this.domainEvents.clear();
        return Collections.unmodifiableList(recordedEvents);
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    public void clearEvents() {
        this.domainEvents.clear();
    }
}

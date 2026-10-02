package com.backintro.domain.diagnosticsystem.event;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public record DiagnosticSystemUpdatedEvent(
    DiagnosticSystemId id,
    String code,
    String name,
    String version,
    LocalDateTime occurredOn
) implements DomainEvent {

    public DiagnosticSystemUpdatedEvent {

        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(
            occurredOn,
            "occurredOn must not be null"
        );
    }
}
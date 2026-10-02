package com.backintro.domain.escalationstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.escalationstatus.event.EscalationStatusRegisteredEvent;
import com.backintro.domain.escalationstatus.event.EscalationStatusUpdatedEvent;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;

public class EscalationStatus extends AggregateRoot {
    private final EscalationStatusId id;
    private String nameStatus;

    private EscalationStatus(
        EscalationStatusId id,
        String nameStatus) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = Objects.requireNonNull(nameStatus, "nameStatus must not be null");
    }

    public static EscalationStatus register(
        String nameStatus) {

        EscalationStatusId id = EscalationStatusId.generate();

        EscalationStatus entity = new EscalationStatus(
            id,
            nameStatus);

        entity.recordEvent(
            new EscalationStatusRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static EscalationStatus restore(
        EscalationStatusId id,
        String nameStatus) {
        return new EscalationStatus(
            id,
            nameStatus);
    }

    public void update(
        String nameStatus) {

        this.nameStatus = Objects.requireNonNull(nameStatus);

        recordEvent(
            new EscalationStatusUpdatedEvent(
                this.id,
                this.nameStatus,
                LocalDateTime.now()));
    }

    public EscalationStatusId id() {
        return id;
    }

    public String nameStatus() {
        return nameStatus;
    }
    // Alias para compatibilidad con mappers y frameworks
    public EscalationStatusId getId() {
        return id();
    }

    public String getNameStatus() {
        return nameStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EscalationStatus that = (EscalationStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EscalationStatus{" +
                "id=" + id +
                '}';
    }
}
package com.backintro.domain.encounterstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encounterstatus.event.EncounterStatusRegisteredEvent;
import com.backintro.domain.encounterstatus.event.EncounterStatusUpdatedEvent;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;

public class EncounterStatus extends AggregateRoot {
    private final EncounterStatusId id;
    private String code;
    private String name;
    private boolean active;

    private EncounterStatus(
        EncounterStatusId id,
        String code,
        String name,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
    }

    public static EncounterStatus register(
        String code,
        String name) {

        EncounterStatusId id = EncounterStatusId.generate();

        EncounterStatus entity = new EncounterStatus(
            id,
            code,
            name,
            true);

        entity.recordEvent(
            new EncounterStatusRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static EncounterStatus restore(
        EncounterStatusId id,
        String code,
        String name,
        boolean active) {
        return new EncounterStatus(
            id,
            code,
            name,
            active);
    }

    public void update(
        String code,
        String name) {

        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);

        recordEvent(
            new EncounterStatusUpdatedEvent(
                this.id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public EncounterStatusId id() {
        return id;
    }

    public String code() {
        return code;
    }
    public String name() {
        return name;
    }
    public boolean active() {
        return active;
    }
    // Alias para compatibilidad con mappers y frameworks
    public EncounterStatusId getId() {
        return id();
    }

    public String getCode() {
        return code();
    }
    public String getName() {
        return name();
    }
    public boolean isActive() {
        return active();
    }

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncounterStatus that = (EncounterStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EncounterStatus{" +
                "id=" + id +
                '}';
    }
}
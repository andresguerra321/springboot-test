package com.backintro.domain.encountertype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encountertype.event.EncounterTypeRegisteredEvent;
import com.backintro.domain.encountertype.event.EncounterTypeUpdatedEvent;
import com.backintro.domain.encountertype.model.valueobject.EncounterTypeId;

public class EncounterType extends AggregateRoot {
    private final EncounterTypeId id;
    private String code;
    private String name;
    private boolean active;

    private EncounterType(
        EncounterTypeId id,
        String code,
        String name,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
    }

    public static EncounterType register(
        String code,
        String name) {

        EncounterTypeId id = EncounterTypeId.generate();

        EncounterType entity = new EncounterType(
            id,
            code,
            name,
            true);

        entity.recordEvent(
            new EncounterTypeRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static EncounterType restore(
        EncounterTypeId id,
        String code,
        String name,
        boolean active) {
        return new EncounterType(
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
            new EncounterTypeUpdatedEvent(
                this.id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public EncounterTypeId id() {
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
    public EncounterTypeId getId() {
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
        EncounterType that = (EncounterType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EncounterType{" +
                "id=" + id +
                '}';
    }
}
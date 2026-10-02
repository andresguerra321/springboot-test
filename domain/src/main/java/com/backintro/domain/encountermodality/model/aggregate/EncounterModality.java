package com.backintro.domain.encountermodality.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.encountermodality.event.EncounterModalityRegisteredEvent;
import com.backintro.domain.encountermodality.event.EncounterModalityUpdatedEvent;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;

public class EncounterModality extends AggregateRoot {
    private final EncounterModalityId id;
    private String code;
    private String name;
    private boolean active;

    private EncounterModality(
        EncounterModalityId id,
        String code,
        String name,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
    }

    public static EncounterModality register(
        String code,
        String name) {

        EncounterModalityId id = EncounterModalityId.generate();

        EncounterModality entity = new EncounterModality(
            id,
            code,
            name,
            true);

        entity.recordEvent(
            new EncounterModalityRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static EncounterModality restore(
        EncounterModalityId id,
        String code,
        String name,
        boolean active) {
        return new EncounterModality(
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
            new EncounterModalityUpdatedEvent(
                this.id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public EncounterModalityId id() {
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
    public EncounterModalityId getId() {
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
        EncounterModality that = (EncounterModality) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EncounterModality{" +
                "id=" + id +
                '}';
    }
}
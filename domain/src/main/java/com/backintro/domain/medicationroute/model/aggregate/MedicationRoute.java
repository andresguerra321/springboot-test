package com.backintro.domain.medicationroute.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.medicationroute.event.MedicationRouteRegisteredEvent;
import com.backintro.domain.medicationroute.event.MedicationRouteUpdatedEvent;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;

public class MedicationRoute extends AggregateRoot {
    private final MedicationRouteId id;
    private String code;
    private String name;
    private boolean active;

    private MedicationRoute(
        MedicationRouteId id,
        String code,
        String name,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
    }

    public static MedicationRoute register(
        String code,
        String name) {

        MedicationRouteId id = MedicationRouteId.generate();

        MedicationRoute entity = new MedicationRoute(
            id,
            code,
            name,
            true);

        entity.recordEvent(
            new MedicationRouteRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static MedicationRoute restore(
        MedicationRouteId id,
        String code,
        String name,
        boolean active) {
        return new MedicationRoute(
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
            new MedicationRouteUpdatedEvent(
                this.id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public MedicationRouteId id() {
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
    public MedicationRouteId getId() {
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
        MedicationRoute that = (MedicationRoute) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MedicationRoute{" +
                "id=" + id +
                '}';
    }
}
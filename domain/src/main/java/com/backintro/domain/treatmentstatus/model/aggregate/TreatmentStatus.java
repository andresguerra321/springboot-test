package com.backintro.domain.treatmentstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentstatus.event.TreatmentStatusRegisteredEvent;
import com.backintro.domain.treatmentstatus.event.TreatmentStatusUpdatedEvent;
import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

public class TreatmentStatus extends AggregateRoot {
    private final TreatmentStatusId id;
    private String code;
    private String name;
    private boolean active;
    private String description;

    private TreatmentStatus(
        TreatmentStatusId id,
        String code,
        String name,
        boolean active,
        String description) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
        this.description = description;
    }

    public static TreatmentStatus register(
        String code,
        String name,
        String description) {

        TreatmentStatusId id = TreatmentStatusId.generate();

        TreatmentStatus entity = new TreatmentStatus(
            id,
            code,
            name,
            true,
            description);

        entity.recordEvent(
            new TreatmentStatusRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static TreatmentStatus restore(
        TreatmentStatusId id,
        String code,
        String name,
        boolean active,
        String description) {
        return new TreatmentStatus(
            id,
            code,
            name,
            active,
            description);
    }

    public void update(
        String code,
        String name,
        String description) {

        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.description = description;

        recordEvent(
            new TreatmentStatusUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.description,
                LocalDateTime.now()));
    }

    public TreatmentStatusId id() {
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
    public String description() {
        return description;
    }
    // Alias para compatibilidad con mappers y frameworks
    public TreatmentStatusId getId() {
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
    public String getDescription() {
        return description();
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
        TreatmentStatus that = (TreatmentStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TreatmentStatus{" +
                "id=" + id +
                '}';
    }
}
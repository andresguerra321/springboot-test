package com.backintro.domain.treatmentgoalstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.treatmentgoalstatus.event.TreatmentGoalStatusRegisteredEvent;
import com.backintro.domain.treatmentgoalstatus.event.TreatmentGoalStatusUpdatedEvent;
import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

public class TreatmentGoalStatus extends AggregateRoot {
    private final TreatmentGoalStatusId id;
    private String code;
    private String name;
    private boolean active;
    private String description;

    private TreatmentGoalStatus(
        TreatmentGoalStatusId id,
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

    public static TreatmentGoalStatus register(
        String code,
        String name,
        String description) {

        TreatmentGoalStatusId id = TreatmentGoalStatusId.generate();

        TreatmentGoalStatus entity = new TreatmentGoalStatus(
            id,
            code,
            name,
            true,
            description);

        entity.recordEvent(
            new TreatmentGoalStatusRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static TreatmentGoalStatus restore(
        TreatmentGoalStatusId id,
        String code,
        String name,
        boolean active,
        String description) {
        return new TreatmentGoalStatus(
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
            new TreatmentGoalStatusUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.description,
                LocalDateTime.now()));
    }

    public TreatmentGoalStatusId id() {
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
    public TreatmentGoalStatusId getId() {
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
        TreatmentGoalStatus that = (TreatmentGoalStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TreatmentGoalStatus{" +
                "id=" + id +
                '}';
    }
}
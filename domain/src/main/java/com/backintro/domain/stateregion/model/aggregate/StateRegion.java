package com.backintro.domain.stateregion.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.stateregion.event.StateRegionRegisteredEvent;
import com.backintro.domain.stateregion.event.StateRegionUpdatedEvent;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;

public class StateRegion extends AggregateRoot {
    private final StateRegionId id;
    private String code;
    private String name;
    private String description;
    private boolean active;
    private UUID countryId;

    private StateRegion(
        StateRegionId id,
        String code,
        String name,
        String description,
        boolean active,
        UUID countryId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.description = description;
        this.active = active;
        this.countryId = Objects.requireNonNull(countryId, "countryId must not be null");
    }

    public static StateRegion register(
        String code,
        String name,
        String description,
        UUID countryId) {

        StateRegionId id = StateRegionId.generate();

        StateRegion entity = new StateRegion(
            id,
            code,
            name,
            description,
            true,
            countryId);

        entity.recordEvent(
            new StateRegionRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static StateRegion restore(
        StateRegionId id,
        String code,
        String name,
        String description,
        boolean active,
        UUID countryId) {
        return new StateRegion(
            id,
            code,
            name,
            description,
            active,
            countryId);
    }

    public void update(
        String code,
        String name,
        String description,
        UUID countryId) {

        this.code = code;
        this.name = Objects.requireNonNull(name);
        this.description = description;
        this.countryId = Objects.requireNonNull(countryId);

        recordEvent(
            new StateRegionUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.description,
                this.countryId,
                LocalDateTime.now()));
    }

    public StateRegionId id() {
        return id;
    }

    public String code() {
        return code;
    }
    public String name() {
        return name;
    }
    public String description() {
        return description;
    }
    public boolean active() {
        return active;
    }
    public UUID countryId() {
        return countryId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public StateRegionId getId() {
        return id();
    }

    public String getCode() {
        return code();
    }
    public String getName() {
        return name();
    }
    public String getDescription() {
        return description();
    }
    public boolean isActive() {
        return active();
    }
    public UUID getCountryId() {
        return countryId();
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
        StateRegion that = (StateRegion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "StateRegion{" +
                "id=" + id +
                '}';
    }
}
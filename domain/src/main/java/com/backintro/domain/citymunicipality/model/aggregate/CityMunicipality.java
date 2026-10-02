package com.backintro.domain.citymunicipality.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.citymunicipality.event.CityMunicipalityRegisteredEvent;
import com.backintro.domain.citymunicipality.event.CityMunicipalityUpdatedEvent;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public class CityMunicipality extends AggregateRoot {
    private final CityMunicipalityId id;
    private String code;
    private String name;
    private String description;
    private boolean active;
    private UUID regionId;

    private CityMunicipality(
        CityMunicipalityId id,
        String code,
        String name,
        String description,
        boolean active,
        UUID regionId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.description = description;
        this.active = active;
        this.regionId = Objects.requireNonNull(regionId, "regionId must not be null");
    }

    public static CityMunicipality register(
        String code,
        String name,
        String description,
        UUID regionId) {

        CityMunicipalityId id = CityMunicipalityId.generate();

        CityMunicipality entity = new CityMunicipality(
            id,
            code,
            name,
            description,
            true,
            regionId);

        entity.recordEvent(
            new CityMunicipalityRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static CityMunicipality restore(
        CityMunicipalityId id,
        String code,
        String name,
        String description,
        boolean active,
        UUID regionId) {
        return new CityMunicipality(
            id,
            code,
            name,
            description,
            active,
            regionId);
    }

    public void update(
        String code,
        String name,
        String description,
        UUID regionId) {

        this.code = code;
        this.name = Objects.requireNonNull(name);
        this.description = description;
        this.regionId = Objects.requireNonNull(regionId);

        recordEvent(
            new CityMunicipalityUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.description,
                this.regionId,
                LocalDateTime.now()));
    }

    public CityMunicipalityId id() {
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
    public UUID regionId() {
        return regionId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public CityMunicipalityId getId() {
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
    public UUID getRegionId() {
        return regionId();
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
        CityMunicipality that = (CityMunicipality) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CityMunicipality{" +
                "id=" + id +
                '}';
    }
}
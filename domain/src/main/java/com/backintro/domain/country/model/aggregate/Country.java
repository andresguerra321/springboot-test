package com.backintro.domain.country.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.country.event.CountryRegisteredEvent;
import com.backintro.domain.country.event.CountryUpdatedEvent;
import com.backintro.domain.country.model.valueobject.CountryId;

public class Country extends AggregateRoot {
    private final CountryId id;
    private String code;
    private String name;
    private String description;
    private boolean active;
    private String telephonePrefix;

    private Country(
        CountryId id,
        String code,
        String name,
        String description,
        boolean active,
        String telephonePrefix) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.description = description;
        this.active = active;
        this.telephonePrefix = telephonePrefix;
    }

    public static Country register(
        String code,
        String name,
        String description,
        String telephonePrefix) {

        CountryId id = CountryId.generate();

        Country entity = new Country(
            id,
            code,
            name,
            description,
            true,
            telephonePrefix);

        entity.recordEvent(
            new CountryRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Country restore(
        CountryId id,
        String code,
        String name,
        String description,
        boolean active,
        String telephonePrefix) {
        return new Country(
            id,
            code,
            name,
            description,
            active,
            telephonePrefix);
    }

    public void update(
        String code,
        String name,
        String description,
        String telephonePrefix) {

        this.code = code;
        this.name = Objects.requireNonNull(name);
        this.description = description;
        this.telephonePrefix = telephonePrefix;

        recordEvent(
            new CountryUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.description,
                this.telephonePrefix,
                LocalDateTime.now()));
    }

    public CountryId id() {
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
    public String telephonePrefix() {
        return telephonePrefix;
    }
    // Alias para compatibilidad con mappers y frameworks
    public CountryId getId() {
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
    public String getTelephonePrefix() {
        return telephonePrefix();
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
        Country that = (Country) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                '}';
    }
}
package com.backintro.domain.country.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.country.event.CountryRegisteredEvent;
import com.backintro.domain.country.event.CountryUpdatedEvent;
import com.backintro.domain.country.model.valueobject.CountryId;

public class Country extends AggregateRoot {
    private final CountryId id;
    private String name;
    private String code;
    private boolean active;

    private Country(
        CountryId id,
        String name,
        String code,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.active = active;
    }

    public static Country register(
        String name,
        String code) {

        CountryId id = CountryId.generate();

        Country country = new Country(
            id,
            name,
            code,
            true);

        country.recordEvent(
            new CountryRegisteredEvent(
                id,
                LocalDateTime.now()));

        return country;
    }

    public static Country restore(
        CountryId id,
        String name,
        String code,
        boolean active) {
        return new Country(
            id,
            name,
            code,
            active);
    }

    public void update(
        String name,
        String code) {

        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);

        recordEvent(
            new CountryUpdatedEvent(
                this.id,
                this.name,
                this.code,
                LocalDateTime.now()));
    }

    public CountryId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String code() {
        return code;
    }

    public boolean active() {
        return active;
    }

    // Alias para compatibilidad con mappers y frameworks
    public CountryId getId() {
        return id();
    }

    public String getName() {
        return name();
    }

    public String getCode() {
        return code();
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
        Country country = (Country) o;
        return Objects.equals(id, country.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", active=" + active +
                '}';
    }
}

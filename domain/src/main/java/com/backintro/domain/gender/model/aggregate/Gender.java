package com.backintro.domain.gender.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.gender.event.GenderRegisteredEvent;
import com.backintro.domain.gender.event.GenderUpdatedEvent;
import com.backintro.domain.gender.model.valueobject.GenderId;

public class Gender extends AggregateRoot {
    private final GenderId id;
    private String description;

    private Gender(
        GenderId id,
        String description) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    public static Gender register(
        String description) {

        GenderId id = GenderId.generate();

        Gender entity = new Gender(
            id,
            description);

        entity.recordEvent(
            new GenderRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Gender restore(
        GenderId id,
        String description) {
        return new Gender(
            id,
            description);
    }

    public void update(
        String description) {

        this.description = Objects.requireNonNull(description);

        recordEvent(
            new GenderUpdatedEvent(
                this.id,
                this.description,
                LocalDateTime.now()));
    }

    public GenderId id() {
        return id;
    }

    public String description() {
        return description;
    }
    // Alias para compatibilidad con mappers y frameworks
    public GenderId getId() {
        return id();
    }

    public String getDescription() {
        return description();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender that = (Gender) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                '}';
    }
}
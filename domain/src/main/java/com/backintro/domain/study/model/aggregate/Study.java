package com.backintro.domain.study.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.study.event.StudyRegisteredEvent;
import com.backintro.domain.study.event.StudyUpdatedEvent;
import com.backintro.domain.study.model.valueobject.StudyId;

public class Study extends AggregateRoot {
    private final StudyId id;
    private String name;

    private Study(
        StudyId id,
        String name) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public static Study register(
        String name) {

        StudyId id = StudyId.generate();

        Study entity = new Study(
            id,
            name);

        entity.recordEvent(
            new StudyRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static Study restore(
        StudyId id,
        String name) {
        return new Study(
            id,
            name);
    }

    public void update(
        String name) {

        this.name = Objects.requireNonNull(name);

        recordEvent(
            new StudyUpdatedEvent(
                this.id,
                this.name,
                LocalDateTime.now()));
    }

    public StudyId id() {
        return id;
    }

    public String name() {
        return name;
    }
    // Alias para compatibilidad con mappers y frameworks
    public StudyId getId() {
        return id();
    }

    public String getName() {
        return name();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Study that = (Study) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Study{" +
                "id=" + id +
                '}';
    }
}
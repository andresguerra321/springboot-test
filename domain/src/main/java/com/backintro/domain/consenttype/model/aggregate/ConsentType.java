package com.backintro.domain.consenttype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.consenttype.event.ConsentTypeRegisteredEvent;
import com.backintro.domain.consenttype.event.ConsentTypeUpdatedEvent;
import com.backintro.domain.consenttype.model.valueobject.ConsentTypeId;

public class ConsentType extends AggregateRoot {
    private final ConsentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private String description;

    private ConsentType(
        ConsentTypeId id,
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

    public static ConsentType register(
        String code,
        String name,
        String description) {

        ConsentTypeId id = ConsentTypeId.generate();

        ConsentType entity = new ConsentType(
            id,
            code,
            name,
            true,
            description);

        entity.recordEvent(
            new ConsentTypeRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ConsentType restore(
        ConsentTypeId id,
        String code,
        String name,
        boolean active,
        String description) {
        return new ConsentType(
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
            new ConsentTypeUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.description,
                LocalDateTime.now()));
    }

    public ConsentTypeId id() {
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
    public ConsentTypeId getId() {
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
        ConsentType that = (ConsentType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ConsentType{" +
                "id=" + id +
                '}';
    }
}
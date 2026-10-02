package com.backintro.domain.risklevel.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.risklevel.event.RiskLevelRegisteredEvent;
import com.backintro.domain.risklevel.event.RiskLevelUpdatedEvent;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public class RiskLevel extends AggregateRoot {
    private final RiskLevelId id;
    private String code;
    private String name;
    private boolean active;
    private Integer severity;

    private RiskLevel(
        RiskLevelId id,
        String code,
        String name,
        boolean active,
        Integer severity) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
        this.severity = severity;
    }

    public static RiskLevel register(
        String code,
        String name,
        Integer severity) {

        RiskLevelId id = RiskLevelId.generate();

        RiskLevel entity = new RiskLevel(
            id,
            code,
            name,
            true,
            severity);

        entity.recordEvent(
            new RiskLevelRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static RiskLevel restore(
        RiskLevelId id,
        String code,
        String name,
        boolean active,
        Integer severity) {
        return new RiskLevel(
            id,
            code,
            name,
            active,
            severity);
    }

    public void update(
        String code,
        String name,
        Integer severity) {

        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.severity = severity;

        recordEvent(
            new RiskLevelUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.severity,
                LocalDateTime.now()));
    }

    public RiskLevelId id() {
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
    public Integer severity() {
        return severity;
    }
    // Alias para compatibilidad con mappers y frameworks
    public RiskLevelId getId() {
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
    public Integer getSeverity() {
        return severity();
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
        RiskLevel that = (RiskLevel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RiskLevel{" +
                "id=" + id +
                '}';
    }
}
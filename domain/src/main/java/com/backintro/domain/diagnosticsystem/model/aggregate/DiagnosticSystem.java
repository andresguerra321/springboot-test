package com.backintro.domain.diagnosticsystem.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.diagnosticsystem.event.DiagnosticSystemRegisteredEvent;
import com.backintro.domain.diagnosticsystem.event.DiagnosticSystemUpdatedEvent;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public class DiagnosticSystem extends AggregateRoot {
    private final DiagnosticSystemId id;
    private String code;
    private String name;
    private boolean active;
    private String version;

    private DiagnosticSystem(
        DiagnosticSystemId id,
        String code,
        String name,
        boolean active,
        String version) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
        this.version = version;
    }

    public static DiagnosticSystem register(
        String code,
        String name,
        String version) {

        DiagnosticSystemId id = DiagnosticSystemId.generate();

        DiagnosticSystem entity = new DiagnosticSystem(
            id,
            code,
            name,
            true,
            version);

        entity.recordEvent(
            new DiagnosticSystemRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static DiagnosticSystem restore(
        DiagnosticSystemId id,
        String code,
        String name,
        boolean active,
        String version) {
        return new DiagnosticSystem(
            id,
            code,
            name,
            active,
            version);
    }

    public void update(
        String code,
        String name,
        String version) {

        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.version = version;

        recordEvent(
            new DiagnosticSystemUpdatedEvent(
                this.id,
                this.code,
                this.name,
                this.version,
                LocalDateTime.now()));
    }

    public DiagnosticSystemId id() {
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
    public String version() {
        return version;
    }
    // Alias para compatibilidad con mappers y frameworks
    public DiagnosticSystemId getId() {
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
    public String getVersion() {
        return version();
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
        DiagnosticSystem that = (DiagnosticSystem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DiagnosticSystem{" +
                "id=" + id +
                '}';
    }
}
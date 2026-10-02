package com.backintro.domain.clinicalrecordstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.clinicalrecordstatus.event.ClinicalRecordStatusRegisteredEvent;
import com.backintro.domain.clinicalrecordstatus.event.ClinicalRecordStatusUpdatedEvent;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public class ClinicalRecordStatus extends AggregateRoot {
    private final ClinicalRecordStatusId id;
    private String code;
    private String name;
    private boolean active;

    private ClinicalRecordStatus(
        ClinicalRecordStatusId id,
        String code,
        String name,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
    }

    public static ClinicalRecordStatus register(
        String code,
        String name) {

        ClinicalRecordStatusId id = ClinicalRecordStatusId.generate();

        ClinicalRecordStatus entity = new ClinicalRecordStatus(
            id,
            code,
            name,
            true);

        entity.recordEvent(
            new ClinicalRecordStatusRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ClinicalRecordStatus restore(
        ClinicalRecordStatusId id,
        String code,
        String name,
        boolean active) {
        return new ClinicalRecordStatus(
            id,
            code,
            name,
            active);
    }

    public void update(
        String code,
        String name) {

        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);

        recordEvent(
            new ClinicalRecordStatusUpdatedEvent(
                this.id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public ClinicalRecordStatusId id() {
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
    // Alias para compatibilidad con mappers y frameworks
    public ClinicalRecordStatusId getId() {
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
        ClinicalRecordStatus that = (ClinicalRecordStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClinicalRecordStatus{" +
                "id=" + id +
                '}';
    }
}
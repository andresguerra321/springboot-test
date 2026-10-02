package com.backintro.domain.airunstatus.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.airunstatus.event.AiRunStatusRegisteredEvent;
import com.backintro.domain.airunstatus.event.AiRunStatusUpdatedEvent;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;

public class AiRunStatus extends AggregateRoot {
    private final AiRunStatusId id;
    private String nameStatus;

    private AiRunStatus(
        AiRunStatusId id,
        String nameStatus) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameStatus = Objects.requireNonNull(nameStatus, "nameStatus must not be null");
    }

    public static AiRunStatus register(
        String nameStatus) {

        AiRunStatusId id = AiRunStatusId.generate();

        AiRunStatus entity = new AiRunStatus(
            id,
            nameStatus);

        entity.recordEvent(
            new AiRunStatusRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static AiRunStatus restore(
        AiRunStatusId id,
        String nameStatus) {
        return new AiRunStatus(
            id,
            nameStatus);
    }

    public void update(
        String nameStatus) {

        this.nameStatus = Objects.requireNonNull(nameStatus);

        recordEvent(
            new AiRunStatusUpdatedEvent(
                this.id,
                this.nameStatus,
                LocalDateTime.now()));
    }

    public AiRunStatusId id() {
        return id;
    }

    public String nameStatus() {
        return nameStatus;
    }
    // Alias para compatibilidad con mappers y frameworks
    public AiRunStatusId getId() {
        return id();
    }

    public String getNameStatus() {
        return nameStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiRunStatus that = (AiRunStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AiRunStatus{" +
                "id=" + id +
                '}';
    }
}
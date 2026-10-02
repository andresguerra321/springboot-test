package com.backintro.domain.sendertype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.sendertype.event.SenderTypeRegisteredEvent;
import com.backintro.domain.sendertype.event.SenderTypeUpdatedEvent;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;

public class SenderType extends AggregateRoot {
    private final SenderTypeId id;
    private String nameType;

    private SenderType(
        SenderTypeId id,
        String nameType) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameType = Objects.requireNonNull(nameType, "nameType must not be null");
    }

    public static SenderType register(
        String nameType) {

        SenderTypeId id = SenderTypeId.generate();

        SenderType entity = new SenderType(
            id,
            nameType);

        entity.recordEvent(
            new SenderTypeRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static SenderType restore(
        SenderTypeId id,
        String nameType) {
        return new SenderType(
            id,
            nameType);
    }

    public void update(
        String nameType) {

        this.nameType = Objects.requireNonNull(nameType);

        recordEvent(
            new SenderTypeUpdatedEvent(
                this.id,
                this.nameType,
                LocalDateTime.now()));
    }

    public SenderTypeId id() {
        return id;
    }

    public String nameType() {
        return nameType;
    }
    // Alias para compatibilidad con mappers y frameworks
    public SenderTypeId getId() {
        return id();
    }

    public String getNameType() {
        return nameType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenderType that = (SenderType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SenderType{" +
                "id=" + id +
                '}';
    }
}
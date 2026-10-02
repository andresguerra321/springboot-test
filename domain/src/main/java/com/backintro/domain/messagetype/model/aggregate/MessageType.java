package com.backintro.domain.messagetype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.messagetype.event.MessageTypeRegisteredEvent;
import com.backintro.domain.messagetype.event.MessageTypeUpdatedEvent;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public class MessageType extends AggregateRoot {
    private final MessageTypeId id;
    private String nameType;

    private MessageType(
        MessageTypeId id,
        String nameType) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameType = Objects.requireNonNull(nameType, "nameType must not be null");
    }

    public static MessageType register(
        String nameType) {

        MessageTypeId id = MessageTypeId.generate();

        MessageType entity = new MessageType(
            id,
            nameType);

        entity.recordEvent(
            new MessageTypeRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static MessageType restore(
        MessageTypeId id,
        String nameType) {
        return new MessageType(
            id,
            nameType);
    }

    public void update(
        String nameType) {

        this.nameType = Objects.requireNonNull(nameType);

        recordEvent(
            new MessageTypeUpdatedEvent(
                this.id,
                this.nameType,
                LocalDateTime.now()));
    }

    public MessageTypeId id() {
        return id;
    }

    public String nameType() {
        return nameType;
    }
    // Alias para compatibilidad con mappers y frameworks
    public MessageTypeId getId() {
        return id();
    }

    public String getNameType() {
        return nameType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageType that = (MessageType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MessageType{" +
                "id=" + id +
                '}';
    }
}
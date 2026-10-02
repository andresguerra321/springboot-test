package com.backintro.domain.relationshiptype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.relationshiptype.event.RelationshipTypeRegisteredEvent;
import com.backintro.domain.relationshiptype.event.RelationshipTypeUpdatedEvent;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public class RelationshipType extends AggregateRoot {
    private final RelationshipTypeId id;
    private String description;

    private RelationshipType(
        RelationshipTypeId id,
        String description) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.description = Objects.requireNonNull(description, "description must not be null");
    }

    public static RelationshipType register(
        String description) {

        RelationshipTypeId id = RelationshipTypeId.generate();

        RelationshipType entity = new RelationshipType(
            id,
            description);

        entity.recordEvent(
            new RelationshipTypeRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static RelationshipType restore(
        RelationshipTypeId id,
        String description) {
        return new RelationshipType(
            id,
            description);
    }

    public void update(
        String description) {

        this.description = Objects.requireNonNull(description);

        recordEvent(
            new RelationshipTypeUpdatedEvent(
                this.id,
                this.description,
                LocalDateTime.now()));
    }

    public RelationshipTypeId id() {
        return id;
    }

    public String description() {
        return description;
    }
    // Alias para compatibilidad con mappers y frameworks
    public RelationshipTypeId getId() {
        return id();
    }

    public String getDescription() {
        return description();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipType that = (RelationshipType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RelationshipType{" +
                "id=" + id +
                '}';
    }
}
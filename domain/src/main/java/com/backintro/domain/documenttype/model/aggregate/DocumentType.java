package com.backintro.domain.documenttype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.documenttype.event.DocumentTypeRegisteredEvent;
import com.backintro.domain.documenttype.event.DocumentTypeUpdatedEvent;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public class DocumentType extends AggregateRoot {
    private final DocumentTypeId id;
    private String code;
    private String name;
    private boolean active;

    private DocumentType(
        DocumentTypeId id,
        String code,
        String name,
        boolean active) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = Objects.requireNonNull(code, "code must not be null");
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.active = active;
    }

    public static DocumentType register(
        String code,
        String name) {

        DocumentTypeId id = DocumentTypeId.generate();

        DocumentType entity = new DocumentType(
            id,
            code,
            name,
            true);

        entity.recordEvent(
            new DocumentTypeRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static DocumentType restore(
        DocumentTypeId id,
        String code,
        String name,
        boolean active) {
        return new DocumentType(
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
            new DocumentTypeUpdatedEvent(
                this.id,
                this.code,
                this.name,
                LocalDateTime.now()));
    }

    public DocumentTypeId id() {
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
    public DocumentTypeId getId() {
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
        DocumentType that = (DocumentType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                '}';
    }
}
package com.backintro.domain.catalog.model.aggregate;

import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Tipo de Relación (parentesco/vínculo).
 * POJO puro sin anotaciones de frameworks.
 */
public class RelationshipType {

    private UUID id;
    private String description;

    public RelationshipType() {
    }

    public RelationshipType(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public static RelationshipType create(String description) {
        return new RelationshipType(UUID.randomUUID(), description);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipType that = (RelationshipType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "RelationshipType{id=" + id + ", description='" + description + "'}";
    }
}

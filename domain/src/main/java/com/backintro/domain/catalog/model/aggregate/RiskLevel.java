package com.backintro.domain.catalog.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Nivel de Riesgo clínico con severidad numérica.
 */
public class RiskLevel {

    private UUID id;
    private String code;
    private String name;
    private Boolean active;
    private Integer severity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public RiskLevel() {}

    public RiskLevel(UUID id, String code, String name, Boolean active, Integer severity,
                     LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active != null ? active : Boolean.TRUE;
        this.severity = severity;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static RiskLevel create(String code, String name, Integer severity) {
        LocalDateTime now = LocalDateTime.now();
        return new RiskLevel(UUID.randomUUID(), code, name, Boolean.TRUE, severity, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Integer getSeverity() { return severity; }
    public void setSeverity(Integer severity) { this.severity = severity; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((RiskLevel) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "RiskLevel{id=" + id + ", code='" + code + "', severity=" + severity + "}";
    }
}

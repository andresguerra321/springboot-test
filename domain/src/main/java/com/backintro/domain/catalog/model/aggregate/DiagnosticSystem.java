package com.backintro.domain.catalog.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Sistema de Diagnóstico (DSM-5, CIE-10, CIE-11, etc.).
 */
public class DiagnosticSystem {

    private UUID id;
    private String code;
    private String name;
    private Boolean active;
    private String version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public DiagnosticSystem() {}

    public DiagnosticSystem(UUID id, String code, String name, Boolean active, String version,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active != null ? active : Boolean.TRUE;
        this.version = version;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static DiagnosticSystem create(String code, String name, String version) {
        LocalDateTime now = LocalDateTime.now();
        return new DiagnosticSystem(UUID.randomUUID(), code, name, Boolean.TRUE, version, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((DiagnosticSystem) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "DiagnosticSystem{id=" + id + ", code='" + code + "', version='" + version + "'}";
    }
}

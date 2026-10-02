package com.backintro.domain.catalog.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Estado de Historia Clínica (abierta, cerrada, etc.).
 */
public class ClinicalRecordStatus {

    private UUID id;
    private String code;
    private String name;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ClinicalRecordStatus() {}

    public ClinicalRecordStatus(UUID id, String code, String name, Boolean active,
                                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.active = active != null ? active : Boolean.TRUE;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ClinicalRecordStatus create(String code, String name) {
        LocalDateTime now = LocalDateTime.now();
        return new ClinicalRecordStatus(UUID.randomUUID(), code, name, Boolean.TRUE, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicalRecordStatus that = (ClinicalRecordStatus) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "ClinicalRecordStatus{id=" + id + ", code='" + code + "', name='" + name + "'}";
    }
}

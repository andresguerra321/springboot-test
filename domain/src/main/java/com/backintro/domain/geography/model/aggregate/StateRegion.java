package com.backintro.domain.geography.model.aggregate;

import com.backintro.domain.geography.model.valueobject.RegionCode;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Estado/Región.
 * Relación ManyToOne con Country (referenciado por ID).
 */
public class StateRegion {

    private UUID id;
    private String nameRegion;
    private RegionCode codeRegion;
    private String description;
    private Boolean isActive;
    private UUID countryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public StateRegion() {}

    public StateRegion(UUID id, String nameRegion, RegionCode codeRegion, String description,
                       Boolean isActive, UUID countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameRegion = nameRegion;
        this.codeRegion = codeRegion;
        this.description = description;
        this.isActive = isActive != null ? isActive : Boolean.TRUE;
        this.countryId = countryId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static StateRegion create(String nameRegion, String codeRegion, String description, UUID countryId) {
        LocalDateTime now = LocalDateTime.now();
        return new StateRegion(UUID.randomUUID(), nameRegion, new RegionCode(codeRegion),
                description, Boolean.TRUE, countryId, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNameRegion() { return nameRegion; }
    public void setNameRegion(String nameRegion) { this.nameRegion = nameRegion; }
    public RegionCode getCodeRegion() { return codeRegion; }
    public void setCodeRegion(RegionCode codeRegion) { this.codeRegion = codeRegion; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }
    public UUID getCountryId() { return countryId; }
    public void setCountryId(UUID countryId) { this.countryId = countryId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((StateRegion) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "StateRegion{id=" + id + ", nameRegion='" + nameRegion + "', countryId=" + countryId + "}";
    }
}

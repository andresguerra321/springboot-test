package com.backintro.domain.geography.model.aggregate;

import com.backintro.domain.geography.model.valueobject.CityCode;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz para Ciudad/Municipio.
 * Relación ManyToOne con StateRegion (referenciado por ID).
 */
public class CityMunicipality {

    private UUID id;
    private String nameCity;
    private CityCode codeCity;
    private String description;
    private Boolean isActive;
    private UUID regionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CityMunicipality() {}

    public CityMunicipality(UUID id, String nameCity, CityCode codeCity, String description,
                            Boolean isActive, UUID regionId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameCity = nameCity;
        this.codeCity = codeCity;
        this.description = description;
        this.isActive = isActive != null ? isActive : Boolean.TRUE;
        this.regionId = regionId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static CityMunicipality create(String nameCity, String codeCity, String description, UUID regionId) {
        LocalDateTime now = LocalDateTime.now();
        return new CityMunicipality(UUID.randomUUID(), nameCity, new CityCode(codeCity),
                description, Boolean.TRUE, regionId, now, now);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNameCity() { return nameCity; }
    public void setNameCity(String nameCity) { this.nameCity = nameCity; }
    public CityCode getCodeCity() { return codeCity; }
    public void setCodeCity(CityCode codeCity) { this.codeCity = codeCity; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean active) { isActive = active; }
    public UUID getRegionId() { return regionId; }
    public void setRegionId(UUID regionId) { this.regionId = regionId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((CityMunicipality) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return "CityMunicipality{id=" + id + ", nameCity='" + nameCity + "', regionId=" + regionId + "}";
    }
}

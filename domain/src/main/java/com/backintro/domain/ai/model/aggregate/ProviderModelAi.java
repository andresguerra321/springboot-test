package com.backintro.domain.ai.model.aggregate;

import com.backintro.domain.common.model.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ProviderModelAi extends AggregateRoot {

    private UUID id;
    private String nameProviderAi;
    private String razonSocial;
    private String sitioWeb;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProviderModelAi() {
    }

    public ProviderModelAi(UUID id, String nameProviderAi, String razonSocial, String sitioWeb,
                           Boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameProviderAi = nameProviderAi;
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        this.isActive = isActive != null ? isActive : Boolean.TRUE;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ProviderModelAi create(String nameProviderAi, String razonSocial, String sitioWeb) {
        LocalDateTime now = LocalDateTime.now();
        return new ProviderModelAi(UUID.randomUUID(), nameProviderAi, razonSocial, sitioWeb, Boolean.TRUE, now, now);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNameProviderAi() {
        return nameProviderAi;
    }

    public void setNameProviderAi(String nameProviderAi) {
        this.nameProviderAi = nameProviderAi;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProviderModelAi that = (ProviderModelAi) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

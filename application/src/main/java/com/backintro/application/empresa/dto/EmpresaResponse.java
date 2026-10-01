package com.backintro.application.empresa.dto;

import com.backintro.domain.empresa.model.aggregate.Empresa;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO de respuesta para la entidad Empresa.
 */
public class EmpresaResponse {

    private UUID id;
    private String nombre;
    private String nit;
    private Boolean activa;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EmpresaResponse() {
    }

    public EmpresaResponse(UUID id, String nombre, String nit, Boolean activa,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.activa = activa;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Mapea un agregado de dominio Empresa hacia EmpresaResponse.
     */
    public static EmpresaResponse fromDomain(Empresa empresa) {
        if (empresa == null) {
            return null;
        }

        String nitValue = empresa.getNit() != null ? empresa.getNit().getValue() : null;

        return new EmpresaResponse(
                empresa.getId(),
                empresa.getNombre(),
                nitValue,
                empresa.getActiva(),
                empresa.getCreatedAt(),
                empresa.getUpdatedAt()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
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
    public String toString() {
        return "EmpresaResponse{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", activa=" + activa +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

package com.backintro.domain.empresa.model.aggregate;

import com.backintro.domain.empresa.event.EmpresaRegisteredEvent;
import com.backintro.domain.empresa.model.valueobject.Nit;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Agregado raíz de Empresa para el dominio de negocio.
 * POJO puro e independiente sin anotaciones de persistencia ni Lombok.
 */
public class Empresa {

    private UUID id;
    private String nombre;
    private Nit nit;
    private Boolean activa;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Empresa() {
    }

    public Empresa(UUID id, String nombre, Nit nit, Boolean activa, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.activa = activa != null ? activa : Boolean.TRUE;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    /**
     * Método fábrica para registrar una nueva empresa y disparar evento de dominio.
     */
    public static Empresa registrar(String nombre, String valorNit) {
        UUID newId = UUID.randomUUID();
        Nit nitObj = new Nit(valorNit);
        LocalDateTime now = LocalDateTime.now();

        Empresa nuevaEmpresa = new Empresa(newId, nombre, nitObj, Boolean.TRUE, now, now);
        // Opcional: registrar EmpresaRegisteredEvent si se usa un event publisher
        return nuevaEmpresa;
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

    public Nit getNit() {
        return nit;
    }

    public void setNit(Nit nit) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", activa=" + activa +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

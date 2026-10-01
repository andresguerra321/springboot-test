package com.backintro.infrastructure.empresa.adapters.in.rest.dtos;

import jakarta.validation.constraints.Size;

/**
 * DTO para la petición HTTP de actualización de Empresa.
 */
public class UpdateEmpresaRequest {

    @Size(max = 150, message = "El nombre no puede superar los 150 caracteres")
    private String nombre;

    @Size(max = 30, message = "El NIT no puede superar los 30 caracteres")
    private String nit;

    private Boolean activa;

    public UpdateEmpresaRequest() {
    }

    public UpdateEmpresaRequest(String nombre, String nit, Boolean activa) {
        this.nombre = nombre;
        this.nit = nit;
        this.activa = activa;
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
}

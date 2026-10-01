package com.backintro.application.empresa.command;

import java.util.UUID;

/**
 * Comando para actualizar una Empresa existente.
 */
public class UpdateEmpresaCommand {

    private UUID id;
    private String nombre;
    private String nit;
    private Boolean activa;

    public UpdateEmpresaCommand() {
    }

    public UpdateEmpresaCommand(UUID id, String nombre, String nit, Boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.activa = activa;
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
}

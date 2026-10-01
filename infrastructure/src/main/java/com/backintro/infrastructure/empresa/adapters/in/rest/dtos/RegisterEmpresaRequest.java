package com.backintro.infrastructure.empresa.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para la petición HTTP de registro de Empresa.
 */
public class RegisterEmpresaRequest {

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    @Size(max = 150, message = "El nombre no puede superar los 150 caracteres")
    private String nombre;

    @NotBlank(message = "El NIT de la empresa es obligatorio")
    @Size(max = 30, message = "El NIT no puede superar los 30 caracteres")
    private String nit;

    public RegisterEmpresaRequest() {
    }

    public RegisterEmpresaRequest(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
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
}

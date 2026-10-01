package com.backintro.application.empresa.command;

/**
 * Comando para registrar una nueva Empresa.
 */
public class RegisterEmpresaCommand {

    private String nombre;
    private String nit;

    public RegisterEmpresaCommand() {
    }

    public RegisterEmpresaCommand(String nombre, String nit) {
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

package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.command.RegisterEmpresaCommand;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.Nit;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

import java.util.Objects;

/**
 * Caso de uso: Registrar una nueva Empresa.
 */
public class RegisterEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    public RegisterEmpresaUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = Objects.requireNonNull(empresaRepository, "EmpresaRepository no puede ser nulo");
    }

    public EmpresaResponse execute(RegisterEmpresaCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("El comando no puede ser nulo");
        }

        // Crear la entidad de dominio pura
        Empresa nuevaEmpresa = Empresa.registrar(command.getNombre(), command.getNit());

        // Persistir mediante el puerto
        Empresa guardada = empresaRepository.save(nuevaEmpresa);

        // Retornar DTO de respuesta
        return EmpresaResponse.fromDomain(guardada);
    }
}

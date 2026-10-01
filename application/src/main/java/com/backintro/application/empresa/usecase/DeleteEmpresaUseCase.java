package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.exception.EmpresaNotFoundApplicationException;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

import java.util.Objects;
import java.util.UUID;

/**
 * Caso de uso: Eliminar una Empresa por su ID.
 */
public class DeleteEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    public DeleteEmpresaUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = Objects.requireNonNull(empresaRepository, "EmpresaRepository no puede ser nulo");
    }

    public void execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        if (!empresaRepository.existsById(id)) {
            throw new EmpresaNotFoundApplicationException(id);
        }

        empresaRepository.deleteById(id);
    }
}

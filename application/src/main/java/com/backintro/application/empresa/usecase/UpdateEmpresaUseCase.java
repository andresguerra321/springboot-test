package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.command.UpdateEmpresaCommand;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.application.empresa.exception.EmpresaNotFoundApplicationException;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.Nit;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Caso de uso: Actualizar los datos de una Empresa existente.
 */
public class UpdateEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    public UpdateEmpresaUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = Objects.requireNonNull(empresaRepository, "EmpresaRepository no puede ser nulo");
    }

    public EmpresaResponse execute(UpdateEmpresaCommand command) {
        if (command == null || command.getId() == null) {
            throw new IllegalArgumentException("El comando y el ID no pueden ser nulos");
        }

        Empresa empresa = empresaRepository.findById(command.getId())
                .orElseThrow(() -> new EmpresaNotFoundApplicationException(command.getId()));

        if (command.getNombre() != null) {
            empresa.setNombre(command.getNombre());
        }
        if (command.getNit() != null) {
            empresa.setNit(new Nit(command.getNit()));
        }
        if (command.getActiva() != null) {
            empresa.setActiva(command.getActiva());
        }
        empresa.setUpdatedAt(LocalDateTime.now());

        Empresa actualizada = empresaRepository.save(empresa);
        return EmpresaResponse.fromDomain(actualizada);
    }
}

package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.application.empresa.exception.EmpresaNotFoundApplicationException;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

import java.util.Objects;
import java.util.UUID;

/**
 * Caso de uso: Consultar una Empresa por su ID.
 */
public class GetEmpresaByIdUseCase {

    private final EmpresaRepository empresaRepository;

    public GetEmpresaByIdUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = Objects.requireNonNull(empresaRepository, "EmpresaRepository no puede ser nulo");
    }

    public EmpresaResponse execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }

        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundApplicationException(id));

        return EmpresaResponse.fromDomain(empresa);
    }
}

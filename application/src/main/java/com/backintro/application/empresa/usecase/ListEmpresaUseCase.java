package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Caso de uso: Listar todas las Empresas registradas.
 */
public class ListEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    public ListEmpresaUseCase(EmpresaRepository empresaRepository) {
        this.empresaRepository = Objects.requireNonNull(empresaRepository, "EmpresaRepository no puede ser nulo");
    }

    public List<EmpresaResponse> execute() {
        List<Empresa> empresas = empresaRepository.findAll();
        List<EmpresaResponse> responses = new ArrayList<>(empresas.size());

        for (Empresa emp : empresas) {
            responses.add(EmpresaResponse.fromDomain(emp));
        }

        return responses;
    }
}

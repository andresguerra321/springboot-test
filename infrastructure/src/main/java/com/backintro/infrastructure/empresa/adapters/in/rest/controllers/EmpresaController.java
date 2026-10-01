package com.backintro.infrastructure.empresa.adapters.in.rest.controllers;

import com.backintro.application.empresa.command.RegisterEmpresaCommand;
import com.backintro.application.empresa.command.UpdateEmpresaCommand;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.application.empresa.usecase.DeleteEmpresaUseCase;
import com.backintro.application.empresa.usecase.GetEmpresaByIdUseCase;
import com.backintro.application.empresa.usecase.ListEmpresaUseCase;
import com.backintro.application.empresa.usecase.RegisterEmpresaUseCase;
import com.backintro.application.empresa.usecase.UpdateEmpresaUseCase;
import com.backintro.infrastructure.empresa.adapters.in.rest.dtos.RegisterEmpresaRequest;
import com.backintro.infrastructure.empresa.adapters.in.rest.dtos.UpdateEmpresaRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Adaptador de entrada REST (Primary / Driving Adapter) para la entidad Empresa.
 */
@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    private final RegisterEmpresaUseCase registerEmpresaUseCase;
    private final GetEmpresaByIdUseCase getEmpresaByIdUseCase;
    private final ListEmpresaUseCase listEmpresaUseCase;
    private final UpdateEmpresaUseCase updateEmpresaUseCase;
    private final DeleteEmpresaUseCase deleteEmpresaUseCase;

    public EmpresaController(RegisterEmpresaUseCase registerEmpresaUseCase,
                             GetEmpresaByIdUseCase getEmpresaByIdUseCase,
                             ListEmpresaUseCase listEmpresaUseCase,
                             UpdateEmpresaUseCase updateEmpresaUseCase,
                             DeleteEmpresaUseCase deleteEmpresaUseCase) {
        this.registerEmpresaUseCase = registerEmpresaUseCase;
        this.getEmpresaByIdUseCase = getEmpresaByIdUseCase;
        this.listEmpresaUseCase = listEmpresaUseCase;
        this.updateEmpresaUseCase = updateEmpresaUseCase;
        this.deleteEmpresaUseCase = deleteEmpresaUseCase;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponse> register(@Valid @RequestBody RegisterEmpresaRequest request) {
        RegisterEmpresaCommand command = new RegisterEmpresaCommand(request.getNombre(), request.getNit());
        EmpresaResponse response = registerEmpresaUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse> getById(@PathVariable UUID id) {
        EmpresaResponse response = getEmpresaByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> listAll() {
        List<EmpresaResponse> list = listEmpresaUseCase.execute();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponse> update(@PathVariable UUID id,
                                                  @Valid @RequestBody UpdateEmpresaRequest request) {
        UpdateEmpresaCommand command = new UpdateEmpresaCommand(
                id,
                request.getNombre(),
                request.getNit(),
                request.getActiva()
        );
        EmpresaResponse response = updateEmpresaUseCase.execute(command);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteEmpresaUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

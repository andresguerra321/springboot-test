package com.backintro.infrastructure.country.adapters.in.rest.controllers;

import com.backintro.application.country.command.RegisterCountryCommand;
import com.backintro.application.country.command.UpdateCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.usecase.DeleteCountryUseCase;
import com.backintro.application.country.usecase.GetCountryByCodeUseCase;
import com.backintro.application.country.usecase.GetCountryByIdUseCase;
import com.backintro.application.country.usecase.ListCountryUseCase;
import com.backintro.application.country.usecase.RegisterCountryUseCase;
import com.backintro.application.country.usecase.UpdateCountryUseCase;
import com.backintro.infrastructure.country.adapters.in.rest.dtos.RegisterCountryRequest;
import com.backintro.infrastructure.country.adapters.in.rest.dtos.UpdateCountryRequest;
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
 * Adaptador de entrada REST para el recurso Country.
 */
@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final RegisterCountryUseCase registerCountryUseCase;
    private final GetCountryByIdUseCase getCountryByIdUseCase;
    private final GetCountryByCodeUseCase getCountryByCodeUseCase;
    private final ListCountryUseCase listCountryUseCase;
    private final UpdateCountryUseCase updateCountryUseCase;
    private final DeleteCountryUseCase deleteCountryUseCase;

    public CountryController(RegisterCountryUseCase registerCountryUseCase,
                             GetCountryByIdUseCase getCountryByIdUseCase,
                             GetCountryByCodeUseCase getCountryByCodeUseCase,
                             ListCountryUseCase listCountryUseCase,
                             UpdateCountryUseCase updateCountryUseCase,
                             DeleteCountryUseCase deleteCountryUseCase) {
        this.registerCountryUseCase = registerCountryUseCase;
        this.getCountryByIdUseCase = getCountryByIdUseCase;
        this.getCountryByCodeUseCase = getCountryByCodeUseCase;
        this.listCountryUseCase = listCountryUseCase;
        this.updateCountryUseCase = updateCountryUseCase;
        this.deleteCountryUseCase = deleteCountryUseCase;
    }

    @PostMapping
    public ResponseEntity<CountryResponse> register(@Valid @RequestBody RegisterCountryRequest request) {
        RegisterCountryCommand command = new RegisterCountryCommand(
                request.getNameCountry(),
                request.getCodeCountry(),
                request.getDescription(),
                request.getTelephonePrefix()
        );
        CountryResponse response = registerCountryUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getById(@PathVariable UUID id) {
        CountryResponse response = getCountryByIdUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CountryResponse> getByCode(@PathVariable String code) {
        CountryResponse response = getCountryByCodeUseCase.execute(code);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponse>> listAll() {
        List<CountryResponse> list = listCountryUseCase.execute();
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable UUID id,
                                                  @Valid @RequestBody UpdateCountryRequest request) {
        UpdateCountryCommand command = new UpdateCountryCommand(
                id,
                request.getNameCountry(),
                request.getCodeCountry(),
                request.getDescription(),
                request.getTelephonePrefix(),
                request.getIsActive()
        );
        CountryResponse response = updateCountryUseCase.execute(command);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteCountryUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

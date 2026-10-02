package com.backintro.application.professionaltype.usecase;

import com.backintro.application.professionaltype.dto.ProfessionalTypeResponse;
import com.backintro.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class GetProfessionalTypeByIdUseCase {

    private final ProfessionalTypeRepository repository;

    public GetProfessionalTypeByIdUseCase(
            ProfessionalTypeRepository repository
    ) {
        this.repository = repository;
    }

    public ProfessionalTypeResponse execute(
            ProfessionalTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ProfessionalTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new ProfessionalTypeResponse(
                entity.id().value(),
                entity.name(),
                null,
                null
        );
    }
}
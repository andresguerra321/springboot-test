package com.backintro.application.professionaltype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.backintro.domain.professionaltype.event.ProfessionalTypeDeletedEvent;
import com.backintro.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.backintro.domain.professionaltype.port.repository.ProfessionalTypeRepository;

public class DeleteProfessionalTypeUseCase {

    private final ProfessionalTypeRepository repository;

    public DeleteProfessionalTypeUseCase(
            ProfessionalTypeRepository repository
    ) {
        this.repository = repository;
    }

    public ProfessionalTypeDeletedEvent execute(
            ProfessionalTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ProfessionalTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new ProfessionalTypeDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}
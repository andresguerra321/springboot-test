package com.backintro.application.gender.usecase;

import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.application.gender.exception.GenderNotFoundApplicationException;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class GetGenderByIdUseCase {

    private final GenderRepository repository;

    public GetGenderByIdUseCase(
            GenderRepository repository
    ) {
        this.repository = repository;
    }

    public GenderResponse execute(
            GenderId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new GenderNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new GenderResponse(
                entity.id().value(),
                entity.description(),
                null,
                null
        );
    }
}
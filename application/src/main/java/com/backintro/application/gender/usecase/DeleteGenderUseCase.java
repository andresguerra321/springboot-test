package com.backintro.application.gender.usecase;

import java.time.LocalDateTime;

import com.backintro.application.gender.exception.GenderNotFoundApplicationException;
import com.backintro.domain.gender.event.GenderDeletedEvent;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class DeleteGenderUseCase {

    private final GenderRepository repository;

    public DeleteGenderUseCase(
            GenderRepository repository
    ) {
        this.repository = repository;
    }

    public GenderDeletedEvent execute(
            GenderId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new GenderNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new GenderDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}
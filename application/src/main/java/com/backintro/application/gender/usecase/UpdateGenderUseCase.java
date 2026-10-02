package com.backintro.application.gender.usecase;

import com.backintro.application.gender.command.UpdateGenderCommand;
import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.application.gender.exception.GenderNotFoundApplicationException;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class UpdateGenderUseCase {

    private final GenderRepository repository;

    public UpdateGenderUseCase(
            GenderRepository repository
    ) {
        this.repository = repository;
    }

    public GenderResponse execute(
            UpdateGenderCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new GenderNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.description()
        );

        var updated =
                repository.save(entity);

        return new GenderResponse(
                updated.id().value(),
                updated.description(),
                null,
                null
        );
    }
}
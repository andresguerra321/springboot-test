package com.backintro.application.study.usecase;

import com.backintro.application.study.command.UpdateStudyCommand;
import com.backintro.application.study.dto.StudyResponse;
import com.backintro.application.study.exception.StudyNotFoundApplicationException;
import com.backintro.domain.study.port.repository.StudyRepository;

public class UpdateStudyUseCase {

    private final StudyRepository repository;

    public UpdateStudyUseCase(
            StudyRepository repository
    ) {
        this.repository = repository;
    }

    public StudyResponse execute(
            UpdateStudyCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new StudyNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.name()
        );

        var updated =
                repository.save(entity);

        return new StudyResponse(
                updated.id().value(),
                updated.name(),
                null,
                null
        );
    }
}
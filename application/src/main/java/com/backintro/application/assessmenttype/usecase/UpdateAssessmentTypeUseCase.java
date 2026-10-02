package com.backintro.application.assessmenttype.usecase;

import com.backintro.application.assessmenttype.command.UpdateAssessmentTypeCommand;
import com.backintro.application.assessmenttype.dto.AssessmentTypeResponse;
import com.backintro.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class UpdateAssessmentTypeUseCase {

    private final AssessmentTypeRepository repository;

    public UpdateAssessmentTypeUseCase(
            AssessmentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public AssessmentTypeResponse execute(
            UpdateAssessmentTypeCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new AssessmentTypeNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name(),
                command.description()
        );

        var updated =
                repository.save(entity);

        return new AssessmentTypeResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                updated.description(),
                null,
                null
        );
    }
}
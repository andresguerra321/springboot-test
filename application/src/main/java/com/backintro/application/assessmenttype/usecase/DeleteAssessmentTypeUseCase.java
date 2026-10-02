package com.backintro.application.assessmenttype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.backintro.domain.assessmenttype.event.AssessmentTypeDeletedEvent;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class DeleteAssessmentTypeUseCase {

    private final AssessmentTypeRepository repository;

    public DeleteAssessmentTypeUseCase(
            AssessmentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public AssessmentTypeDeletedEvent execute(
            AssessmentTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new AssessmentTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new AssessmentTypeDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}
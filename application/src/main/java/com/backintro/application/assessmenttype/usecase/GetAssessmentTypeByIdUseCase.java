package com.backintro.application.assessmenttype.usecase;

import com.backintro.application.assessmenttype.dto.AssessmentTypeResponse;
import com.backintro.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;

public class GetAssessmentTypeByIdUseCase {

    private final AssessmentTypeRepository repository;

    public GetAssessmentTypeByIdUseCase(
            AssessmentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public AssessmentTypeResponse execute(
            AssessmentTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new AssessmentTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new AssessmentTypeResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                entity.description(),
                null,
                null
        );
    }
}
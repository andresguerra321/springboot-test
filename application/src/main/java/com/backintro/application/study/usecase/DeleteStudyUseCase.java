package com.backintro.application.study.usecase;

import java.time.LocalDateTime;

import com.backintro.application.study.exception.StudyNotFoundApplicationException;
import com.backintro.domain.study.event.StudyDeletedEvent;
import com.backintro.domain.study.model.valueobject.StudyId;
import com.backintro.domain.study.port.repository.StudyRepository;

public class DeleteStudyUseCase {

    private final StudyRepository repository;

    public DeleteStudyUseCase(
            StudyRepository repository
    ) {
        this.repository = repository;
    }

    public StudyDeletedEvent execute(
            StudyId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new StudyNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new StudyDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}
package com.backintro.application.mentalstatusexam.usecase;

import java.time.LocalDateTime;

import com.backintro.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.backintro.domain.mentalstatusexam.event.MentalStatusExamDeletedEvent;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class DeleteMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public DeleteMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        this.repository = repository;
    }

    public MentalStatusExamDeletedEvent execute(MentalStatusExamId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new MentalStatusExamDeletedEvent(id, LocalDateTime.now());
    }
}
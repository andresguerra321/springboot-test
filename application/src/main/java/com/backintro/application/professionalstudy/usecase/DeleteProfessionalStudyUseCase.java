package com.backintro.application.professionalstudy.usecase;

import java.time.LocalDateTime;

import com.backintro.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.backintro.domain.professionalstudy.event.ProfessionalStudyDeletedEvent;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class DeleteProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;

    public DeleteProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        this.repository = repository;
    }

    public ProfessionalStudyDeletedEvent execute(ProfessionalStudyId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ProfessionalStudyDeletedEvent(id, LocalDateTime.now());
    }
}
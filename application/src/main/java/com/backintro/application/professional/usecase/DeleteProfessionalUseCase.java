package com.backintro.application.professional.usecase;

import java.time.LocalDateTime;

import com.backintro.application.professional.exception.ProfessionalNotFoundApplicationException;
import com.backintro.domain.professional.event.ProfessionalDeletedEvent;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class DeleteProfessionalUseCase {
    private final ProfessionalRepository repository;

    public DeleteProfessionalUseCase(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public ProfessionalDeletedEvent execute(ProfessionalId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ProfessionalNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ProfessionalDeletedEvent(id, LocalDateTime.now());
    }
}
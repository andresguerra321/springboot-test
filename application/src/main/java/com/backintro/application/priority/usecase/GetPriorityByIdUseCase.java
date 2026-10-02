package com.backintro.application.priority.usecase;

import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.application.priority.exception.PriorityNotFoundApplicationException;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class GetPriorityByIdUseCase {
    private final PriorityRepository repository;

    public GetPriorityByIdUseCase(
            PriorityRepository repository
    ) {
        this.repository = repository;
    }

    public PriorityResponse execute(PriorityId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PriorityNotFoundApplicationException(id.value().toString()));
        return new PriorityResponse(
                entity.id().value(),
                entity.namePriority(),
                null,
                null
        );
    }
}
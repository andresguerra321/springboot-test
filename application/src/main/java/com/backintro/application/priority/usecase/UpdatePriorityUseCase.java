package com.backintro.application.priority.usecase;

import com.backintro.application.priority.command.UpdatePriorityCommand;
import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.application.priority.exception.PriorityNotFoundApplicationException;
import com.backintro.domain.priority.port.repository.PriorityRepository;

public class UpdatePriorityUseCase {
    private final PriorityRepository repository;

    public UpdatePriorityUseCase(
            PriorityRepository repository
    ) {
        this.repository = repository;
    }

    public PriorityResponse execute(UpdatePriorityCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new PriorityNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.namePriority()
        );

        var updated = repository.save(entity);
        return new PriorityResponse(
                updated.id().value(),
                updated.namePriority(),
                null,
                null
        );
    }
}
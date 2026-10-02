package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.command.UpdateAiRunStatusCommand;
import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class UpdateAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public UpdateAiRunStatusUseCase(
            AiRunStatusRepository repository
    ) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(UpdateAiRunStatusCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.nameStatus()
        );

        var updated = repository.save(entity);
        return new AiRunStatusResponse(
                updated.id().value(),
                updated.nameStatus(),
                null,
                null
        );
    }
}
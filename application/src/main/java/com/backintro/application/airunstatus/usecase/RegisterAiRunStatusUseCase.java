package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.command.RegisterAiRunStatusCommand;
import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.domain.airunstatus.model.aggregate.AiRunStatus;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class RegisterAiRunStatusUseCase {
    private final AiRunStatusRepository repository;

    public RegisterAiRunStatusUseCase(
            AiRunStatusRepository repository
    ) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(RegisterAiRunStatusCommand command) {
        AiRunStatus entity = AiRunStatus.register(
                command.nameStatus()
        );
        AiRunStatus saved = repository.save(entity);
        return new AiRunStatusResponse(
                saved.id().value(),
                saved.nameStatus(),
                null,
                null
        );
    }
}
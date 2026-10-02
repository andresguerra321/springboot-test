package com.backintro.application.airunstatus.usecase;

import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.domain.airunstatus.port.repository.AiRunStatusRepository;

public class GetAiRunStatusByIdUseCase {
    private final AiRunStatusRepository repository;

    public GetAiRunStatusByIdUseCase(
            AiRunStatusRepository repository
    ) {
        this.repository = repository;
    }

    public AiRunStatusResponse execute(AiRunStatusId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(id.value().toString()));
        return new AiRunStatusResponse(
                entity.id().value(),
                entity.nameStatus(),
                null,
                null
        );
    }
}
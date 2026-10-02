package com.backintro.application.escalationstatus.usecase;

import com.backintro.application.escalationstatus.dto.EscalationStatusResponse;
import com.backintro.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class GetEscalationStatusByIdUseCase {
    private final EscalationStatusRepository repository;

    public GetEscalationStatusByIdUseCase(
            EscalationStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(EscalationStatusId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(id.value().toString()));
        return new EscalationStatusResponse(
                entity.id().value(),
                entity.nameStatus(),
                null,
                null
        );
    }
}
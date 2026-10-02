package com.backintro.application.escalationstatus.usecase;

import com.backintro.application.escalationstatus.command.UpdateEscalationStatusCommand;
import com.backintro.application.escalationstatus.dto.EscalationStatusResponse;
import com.backintro.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class UpdateEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public UpdateEscalationStatusUseCase(
            EscalationStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(UpdateEscalationStatusCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.nameStatus()
        );

        var updated = repository.save(entity);
        return new EscalationStatusResponse(
                updated.id().value(),
                updated.nameStatus(),
                null,
                null
        );
    }
}
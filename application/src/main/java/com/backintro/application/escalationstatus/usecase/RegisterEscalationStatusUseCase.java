package com.backintro.application.escalationstatus.usecase;

import com.backintro.application.escalationstatus.command.RegisterEscalationStatusCommand;
import com.backintro.application.escalationstatus.dto.EscalationStatusResponse;
import com.backintro.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.backintro.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class RegisterEscalationStatusUseCase {
    private final EscalationStatusRepository repository;

    public RegisterEscalationStatusUseCase(
            EscalationStatusRepository repository
    ) {
        this.repository = repository;
    }

    public EscalationStatusResponse execute(RegisterEscalationStatusCommand command) {
        EscalationStatus entity = EscalationStatus.register(
                command.nameStatus()
        );
        EscalationStatus saved = repository.save(entity);
        return new EscalationStatusResponse(
                saved.id().value(),
                saved.nameStatus(),
                null,
                null
        );
    }
}
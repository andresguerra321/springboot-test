package com.backintro.application.sendertype.usecase;

import com.backintro.application.sendertype.command.UpdateSenderTypeCommand;
import com.backintro.application.sendertype.dto.SenderTypeResponse;
import com.backintro.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class UpdateSenderTypeUseCase {
    private final SenderTypeRepository repository;

    public UpdateSenderTypeUseCase(
            SenderTypeRepository repository
    ) {
        this.repository = repository;
    }

    public SenderTypeResponse execute(UpdateSenderTypeCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.nameType()
        );

        var updated = repository.save(entity);
        return new SenderTypeResponse(
                updated.id().value(),
                updated.nameType(),
                null,
                null
        );
    }
}
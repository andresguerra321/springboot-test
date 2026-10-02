package com.backintro.application.messagetype.usecase;

import com.backintro.application.messagetype.command.UpdateMessageTypeCommand;
import com.backintro.application.messagetype.dto.MessageTypeResponse;
import com.backintro.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class UpdateMessageTypeUseCase {
    private final MessageTypeRepository repository;

    public UpdateMessageTypeUseCase(
            MessageTypeRepository repository
    ) {
        this.repository = repository;
    }

    public MessageTypeResponse execute(UpdateMessageTypeCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.nameType()
        );

        var updated = repository.save(entity);
        return new MessageTypeResponse(
                updated.id().value(),
                updated.nameType(),
                null,
                null
        );
    }
}
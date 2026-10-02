package com.backintro.application.chatmessage.usecase;

import com.backintro.application.chatmessage.command.UpdateChatMessageCommand;
import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class UpdateChatMessageUseCase {
    private final ChatMessageRepository repository;
    private final MessageTypeRepository messageTypeRepository;

    public UpdateChatMessageUseCase(
            ChatMessageRepository repository,
            MessageTypeRepository messageTypeRepository
    ) {
        this.repository = repository;
        this.messageTypeRepository = messageTypeRepository;
    }

    public ChatMessageResponse execute(UpdateChatMessageCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.conversationId(),
                command.messageTypeId(),
                command.participantId(),
                command.content(),
                command.metadata()
        );

        var updated = repository.save(entity);
        return new ChatMessageResponse(
                updated.id().value(),
                updated.conversationId(),
                updated.messageTypeId(),
                messageTypeRepository.findById(new com.backintro.domain.messagetype.model.valueobject.MessageTypeId(updated.messageTypeId())).map(c -> c.nameType()).orElse(null),
                updated.participantId(),
                updated.content(),
                updated.metadata(),
                null
        );
    }
}
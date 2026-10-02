package com.backintro.application.chatmessage.usecase;

import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class GetChatMessageByIdUseCase {
    private final ChatMessageRepository repository;
    private final MessageTypeRepository messageTypeRepository;

    public GetChatMessageByIdUseCase(
            ChatMessageRepository repository,
            MessageTypeRepository messageTypeRepository
    ) {
        this.repository = repository;
        this.messageTypeRepository = messageTypeRepository;
    }

    public ChatMessageResponse execute(ChatMessageId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(id.value().toString()));
        return new ChatMessageResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.messageTypeId(),
                messageTypeRepository.findById(new com.backintro.domain.messagetype.model.valueobject.MessageTypeId(entity.messageTypeId())).map(c -> c.nameType()).orElse(null),
                entity.participantId(),
                entity.content(),
                entity.metadata(),
                null
        );
    }
}
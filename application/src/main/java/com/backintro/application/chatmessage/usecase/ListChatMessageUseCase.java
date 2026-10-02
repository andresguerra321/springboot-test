package com.backintro.application.chatmessage.usecase;

import java.util.List;

import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class ListChatMessageUseCase {
    private final ChatMessageRepository repository;
    private final MessageTypeRepository messageTypeRepository;

    public ListChatMessageUseCase(
            ChatMessageRepository repository,
            MessageTypeRepository messageTypeRepository
    ) {
        this.repository = repository;
        this.messageTypeRepository = messageTypeRepository;
    }

    public List<ChatMessageResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatMessageResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.messageTypeId(),
                messageTypeRepository.findById(new com.backintro.domain.messagetype.model.valueobject.MessageTypeId(entity.messageTypeId())).map(c -> c.nameType()).orElse(null),
                entity.participantId(),
                entity.content(),
                entity.metadata(),
                null
                ))
                .toList();
    }
}
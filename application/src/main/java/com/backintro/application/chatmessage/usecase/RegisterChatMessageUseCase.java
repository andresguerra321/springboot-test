package com.backintro.application.chatmessage.usecase;

import com.backintro.application.chatmessage.command.RegisterChatMessageCommand;
import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.domain.chatmessage.model.aggregate.ChatMessage;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class RegisterChatMessageUseCase {
    private final ChatMessageRepository repository;
    private final MessageTypeRepository messageTypeRepository;

    public RegisterChatMessageUseCase(
            ChatMessageRepository repository,
            MessageTypeRepository messageTypeRepository
    ) {
        this.repository = repository;
        this.messageTypeRepository = messageTypeRepository;
    }

    public ChatMessageResponse execute(RegisterChatMessageCommand command) {
        ChatMessage entity = ChatMessage.register(
                command.conversationId(),
                command.messageTypeId(),
                command.participantId(),
                command.content(),
                command.metadata()
        );
        ChatMessage saved = repository.save(entity);
        return new ChatMessageResponse(
                saved.id().value(),
                saved.conversationId(),
                saved.messageTypeId(),
                messageTypeRepository.findById(new com.backintro.domain.messagetype.model.valueobject.MessageTypeId(saved.messageTypeId())).map(c -> c.nameType()).orElse(null),
                saved.participantId(),
                saved.content(),
                saved.metadata(),
                null
        );
    }
}
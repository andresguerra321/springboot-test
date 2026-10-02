package com.backintro.application.chatparticipant.usecase;

import com.backintro.application.chatparticipant.command.RegisterChatParticipantCommand;
import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class RegisterChatParticipantUseCase {
    private final ChatParticipantRepository repository;
    private final SenderTypeRepository senderTypeRepository;

    public RegisterChatParticipantUseCase(
            ChatParticipantRepository repository,
            SenderTypeRepository senderTypeRepository
    ) {
        this.repository = repository;
        this.senderTypeRepository = senderTypeRepository;
    }

    public ChatParticipantResponse execute(RegisterChatParticipantCommand command) {
        ChatParticipant entity = ChatParticipant.register(
                command.conversationId(),
                command.participantTypeId(),
                command.patientId(),
                command.professionalId()
        );
        ChatParticipant saved = repository.save(entity);
        return new ChatParticipantResponse(
                saved.id().value(),
                saved.conversationId(),
                saved.participantTypeId(),
                senderTypeRepository.findById(new com.backintro.domain.sendertype.model.valueobject.SenderTypeId(saved.participantTypeId())).map(c -> c.nameType()).orElse(null),
                saved.patientId(),
                saved.professionalId(),
                null,
                null
        );
    }
}
package com.backintro.application.chatparticipant.usecase;

import com.backintro.application.chatparticipant.command.UpdateChatParticipantCommand;
import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class UpdateChatParticipantUseCase {
    private final ChatParticipantRepository repository;
    private final SenderTypeRepository senderTypeRepository;

    public UpdateChatParticipantUseCase(
            ChatParticipantRepository repository,
            SenderTypeRepository senderTypeRepository
    ) {
        this.repository = repository;
        this.senderTypeRepository = senderTypeRepository;
    }

    public ChatParticipantResponse execute(UpdateChatParticipantCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.conversationId(),
                command.participantTypeId(),
                command.patientId(),
                command.professionalId()
        );

        var updated = repository.save(entity);
        return new ChatParticipantResponse(
                updated.id().value(),
                updated.conversationId(),
                updated.participantTypeId(),
                senderTypeRepository.findById(new com.backintro.domain.sendertype.model.valueobject.SenderTypeId(updated.participantTypeId())).map(c -> c.nameType()).orElse(null),
                updated.patientId(),
                updated.professionalId(),
                null,
                null
        );
    }
}
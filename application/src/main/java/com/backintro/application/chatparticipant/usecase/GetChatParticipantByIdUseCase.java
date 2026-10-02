package com.backintro.application.chatparticipant.usecase;

import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class GetChatParticipantByIdUseCase {
    private final ChatParticipantRepository repository;
    private final SenderTypeRepository senderTypeRepository;

    public GetChatParticipantByIdUseCase(
            ChatParticipantRepository repository,
            SenderTypeRepository senderTypeRepository
    ) {
        this.repository = repository;
        this.senderTypeRepository = senderTypeRepository;
    }

    public ChatParticipantResponse execute(ChatParticipantId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(id.value().toString()));
        return new ChatParticipantResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.participantTypeId(),
                senderTypeRepository.findById(new com.backintro.domain.sendertype.model.valueobject.SenderTypeId(entity.participantTypeId())).map(c -> c.nameType()).orElse(null),
                entity.patientId(),
                entity.professionalId(),
                null,
                null
        );
    }
}
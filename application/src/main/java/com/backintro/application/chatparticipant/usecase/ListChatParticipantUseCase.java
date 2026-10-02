package com.backintro.application.chatparticipant.usecase;

import java.util.List;

import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class ListChatParticipantUseCase {
    private final ChatParticipantRepository repository;
    private final SenderTypeRepository senderTypeRepository;

    public ListChatParticipantUseCase(
            ChatParticipantRepository repository,
            SenderTypeRepository senderTypeRepository
    ) {
        this.repository = repository;
        this.senderTypeRepository = senderTypeRepository;
    }

    public List<ChatParticipantResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatParticipantResponse(
                entity.id().value(),
                entity.conversationId(),
                entity.participantTypeId(),
                senderTypeRepository.findById(new com.backintro.domain.sendertype.model.valueobject.SenderTypeId(entity.participantTypeId())).map(c -> c.nameType()).orElse(null),
                entity.patientId(),
                entity.professionalId(),
                null,
                null
                ))
                .toList();
    }
}
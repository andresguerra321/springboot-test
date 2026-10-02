package com.backintro.application.chatparticipant.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.backintro.domain.chatparticipant.event.ChatParticipantDeletedEvent;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class DeleteChatParticipantUseCase {
    private final ChatParticipantRepository repository;

    public DeleteChatParticipantUseCase(ChatParticipantRepository repository) {
        this.repository = repository;
    }

    public ChatParticipantDeletedEvent execute(ChatParticipantId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatParticipantDeletedEvent(id, LocalDateTime.now());
    }
}
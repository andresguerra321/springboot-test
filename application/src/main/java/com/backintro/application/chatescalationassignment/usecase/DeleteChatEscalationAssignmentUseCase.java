package com.backintro.application.chatescalationassignment.usecase;

import java.time.LocalDateTime;

import com.backintro.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.backintro.domain.chatescalationassignment.event.ChatEscalationAssignmentDeletedEvent;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class DeleteChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;

    public DeleteChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository repository) {
        this.repository = repository;
    }

    public ChatEscalationAssignmentDeletedEvent execute(ChatEscalationAssignmentId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(id.value().toString()));
        repository.delete(entity);
        return new ChatEscalationAssignmentDeletedEvent(id, LocalDateTime.now());
    }
}
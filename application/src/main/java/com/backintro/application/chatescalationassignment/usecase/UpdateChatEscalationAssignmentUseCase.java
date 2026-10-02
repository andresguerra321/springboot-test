package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.command.UpdateChatEscalationAssignmentCommand;
import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class UpdateChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;
    private final ProfessionalRepository professionalRepository;

    public UpdateChatEscalationAssignmentUseCase(
            ChatEscalationAssignmentRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public ChatEscalationAssignmentResponse execute(UpdateChatEscalationAssignmentCommand command) {
        var entity = repository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(command.id().value().toString()));

        entity.update(
                command.escalationId(),
                command.professionalId(),
                command.assignedAt()
        );

        var updated = repository.save(entity);
        return new ChatEscalationAssignmentResponse(
                updated.id().value(),
                updated.escalationId(),
                updated.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(updated.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                updated.assignedAt()
        );
    }
}
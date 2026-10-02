package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class GetChatEscalationAssignmentByIdUseCase {
    private final ChatEscalationAssignmentRepository repository;
    private final ProfessionalRepository professionalRepository;

    public GetChatEscalationAssignmentByIdUseCase(
            ChatEscalationAssignmentRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public ChatEscalationAssignmentResponse execute(ChatEscalationAssignmentId id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(id.value().toString()));
        return new ChatEscalationAssignmentResponse(
                entity.id().value(),
                entity.escalationId(),
                entity.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(entity.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.assignedAt()
        );
    }
}
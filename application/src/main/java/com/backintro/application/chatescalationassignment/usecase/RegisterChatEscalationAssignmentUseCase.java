package com.backintro.application.chatescalationassignment.usecase;

import com.backintro.application.chatescalationassignment.command.RegisterChatEscalationAssignmentCommand;
import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class RegisterChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;
    private final ProfessionalRepository professionalRepository;

    public RegisterChatEscalationAssignmentUseCase(
            ChatEscalationAssignmentRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public ChatEscalationAssignmentResponse execute(RegisterChatEscalationAssignmentCommand command) {
        ChatEscalationAssignment entity = ChatEscalationAssignment.register(
                command.escalationId(),
                command.professionalId(),
                command.assignedAt()
        );
        ChatEscalationAssignment saved = repository.save(entity);
        return new ChatEscalationAssignmentResponse(
                saved.id().value(),
                saved.escalationId(),
                saved.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(saved.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                saved.assignedAt()
        );
    }
}
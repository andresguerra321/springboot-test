package com.backintro.application.chatescalationassignment.usecase;

import java.util.List;

import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class ListChatEscalationAssignmentUseCase {
    private final ChatEscalationAssignmentRepository repository;
    private final ProfessionalRepository professionalRepository;

    public ListChatEscalationAssignmentUseCase(
            ChatEscalationAssignmentRepository repository,
            ProfessionalRepository professionalRepository
    ) {
        this.repository = repository;
        this.professionalRepository = professionalRepository;
    }

    public List<ChatEscalationAssignmentResponse> execute() {
        return repository.findAll()
                .stream()
                .map(entity -> new ChatEscalationAssignmentResponse(
                entity.id().value(),
                entity.escalationId(),
                entity.professionalId(),
                professionalRepository.findById(new com.backintro.domain.professional.model.valueobject.ProfessionalId(entity.professionalId())).map(c -> c.firstName() + " " + c.lastName()).orElse(null),
                entity.assignedAt()
                ))
                .toList();
    }
}
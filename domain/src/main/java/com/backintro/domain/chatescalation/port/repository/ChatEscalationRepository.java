package com.backintro.domain.chatescalation.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.chatescalation.model.aggregate.ChatEscalation;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;

public interface ChatEscalationRepository {
    ChatEscalation save(ChatEscalation entity);
    Optional<ChatEscalation> findById(ChatEscalationId id);
    List<ChatEscalation> findAll();
    void delete(ChatEscalation entity);
}
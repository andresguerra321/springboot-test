package com.backintro.domain.chat.port.repository;

import com.backintro.domain.chat.model.aggregate.ChatConversation;
import com.backintro.domain.chat.model.aggregate.ChatMessage;
import com.backintro.domain.chat.model.aggregate.ChatParticipant;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatConversationRepository {

    ChatConversation save(ChatConversation conversation);

    Optional<ChatConversation> findById(UUID id);

    List<ChatConversation> findAll();

    void deleteById(UUID id);

    boolean existsById(UUID id);

    ChatMessage saveMessage(ChatMessage message);

    List<ChatMessage> findMessagesByConversationId(UUID conversationId);

    ChatParticipant saveParticipant(ChatParticipant participant);

    List<ChatParticipant> findParticipantsByConversationId(UUID conversationId);
}

package com.backintro.domain.chatparticipant.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatparticipant.event.ChatParticipantRegisteredEvent;
import com.backintro.domain.chatparticipant.event.ChatParticipantUpdatedEvent;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;

public class ChatParticipant extends AggregateRoot {
    private final ChatParticipantId id;
    private UUID conversationId;
    private UUID participantTypeId;
    private UUID patientId;
    private UUID professionalId;

    private ChatParticipant(
        ChatParticipantId id,
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId) {

        this.id = Objects.requireNonNull(id, "id must not be null");
        this.conversationId = Objects.requireNonNull(conversationId, "conversationId must not be null");
        this.participantTypeId = Objects.requireNonNull(participantTypeId, "participantTypeId must not be null");
        this.patientId = patientId;
        this.professionalId = professionalId;
    }

    public static ChatParticipant register(
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId) {

        ChatParticipantId id = ChatParticipantId.generate();

        ChatParticipant entity = new ChatParticipant(
            id,
            conversationId,
            participantTypeId,
            patientId,
            professionalId);

        entity.recordEvent(
            new ChatParticipantRegisteredEvent(
                id,
                LocalDateTime.now()));

        return entity;
    }

    public static ChatParticipant restore(
        ChatParticipantId id,
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId) {
        return new ChatParticipant(
            id,
            conversationId,
            participantTypeId,
            patientId,
            professionalId);
    }

    public void update(
        UUID conversationId,
        UUID participantTypeId,
        UUID patientId,
        UUID professionalId) {

        this.conversationId = Objects.requireNonNull(conversationId);
        this.participantTypeId = Objects.requireNonNull(participantTypeId);
        this.patientId = patientId;
        this.professionalId = professionalId;

        recordEvent(
            new ChatParticipantUpdatedEvent(
                this.id,
                this.conversationId,
                this.participantTypeId,
                this.patientId,
                this.professionalId,
                LocalDateTime.now()));
    }

    public ChatParticipantId id() {
        return id;
    }

    public UUID conversationId() {
        return conversationId;
    }
    public UUID participantTypeId() {
        return participantTypeId;
    }
    public UUID patientId() {
        return patientId;
    }
    public UUID professionalId() {
        return professionalId;
    }
    // Alias para compatibilidad con mappers y frameworks
    public ChatParticipantId getId() {
        return id();
    }

    public UUID getConversationId() {
        return conversationId();
    }
    public UUID getParticipantTypeId() {
        return participantTypeId();
    }
    public UUID getPatientId() {
        return patientId();
    }
    public UUID getProfessionalId() {
        return professionalId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatParticipant that = (ChatParticipant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ChatParticipant{" +
                "id=" + id +
                '}';
    }
}
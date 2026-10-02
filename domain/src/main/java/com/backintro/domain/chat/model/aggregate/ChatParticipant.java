package com.backintro.domain.chat.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class ChatParticipant {

    private UUID id;
    private UUID conversationId;
    private UUID participantTypeId;
    private UUID patientId;
    private UUID professionalId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ChatParticipant() {
    }

    public ChatParticipant(UUID id, UUID conversationId, UUID participantTypeId, UUID patientId,
                           UUID professionalId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.conversationId = conversationId;
        this.participantTypeId = participantTypeId;
        this.patientId = patientId;
        this.professionalId = professionalId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.updatedAt = updatedAt != null ? updatedAt : LocalDateTime.now();
    }

    public static ChatParticipant forPatient(UUID conversationId, UUID participantTypeId, UUID patientId) {
        LocalDateTime now = LocalDateTime.now();
        return new ChatParticipant(UUID.randomUUID(), conversationId, participantTypeId, patientId, null, now, now);
    }

    public static ChatParticipant forProfessional(UUID conversationId, UUID participantTypeId, UUID professionalId) {
        LocalDateTime now = LocalDateTime.now();
        return new ChatParticipant(UUID.randomUUID(), conversationId, participantTypeId, null, professionalId, now, now);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getConversationId() {
        return conversationId;
    }

    public void setConversationId(UUID conversationId) {
        this.conversationId = conversationId;
    }

    public UUID getParticipantTypeId() {
        return participantTypeId;
    }

    public void setParticipantTypeId(UUID participantTypeId) {
        this.participantTypeId = participantTypeId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(UUID professionalId) {
        this.professionalId = professionalId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
}

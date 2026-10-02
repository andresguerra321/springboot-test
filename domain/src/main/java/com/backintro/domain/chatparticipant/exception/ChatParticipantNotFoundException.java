package com.backintro.domain.chatparticipant.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatParticipantNotFoundException extends DomainException {
    public ChatParticipantNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatParticipantNotFoundException(String message) {
        super(message);
    }
}
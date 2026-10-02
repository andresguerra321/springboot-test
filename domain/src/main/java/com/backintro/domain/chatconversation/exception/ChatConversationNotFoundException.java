package com.backintro.domain.chatconversation.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatConversationNotFoundException extends DomainException {
    public ChatConversationNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatConversationNotFoundException(String message) {
        super(message);
    }
}
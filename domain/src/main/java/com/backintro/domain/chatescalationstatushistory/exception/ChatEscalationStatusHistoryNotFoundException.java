package com.backintro.domain.chatescalationstatushistory.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatEscalationStatusHistoryNotFoundException extends DomainException {
    public ChatEscalationStatusHistoryNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatEscalationStatusHistoryNotFoundException(String message) {
        super(message);
    }
}
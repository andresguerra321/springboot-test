package com.backintro.domain.chatescalationassignment.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatEscalationAssignmentNotFoundException extends DomainException {
    public ChatEscalationAssignmentNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatEscalationAssignmentNotFoundException(String message) {
        super(message);
    }
}
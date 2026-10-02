package com.backintro.domain.chatescalationassignment.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatEscalationAssignmentAlreadyExistsException extends DomainException {
    public ChatEscalationAssignmentAlreadyExistsException(String message) {
        super(message);
    }
}
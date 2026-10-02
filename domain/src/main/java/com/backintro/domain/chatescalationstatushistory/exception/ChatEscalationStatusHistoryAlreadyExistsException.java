package com.backintro.domain.chatescalationstatushistory.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatEscalationStatusHistoryAlreadyExistsException extends DomainException {
    public ChatEscalationStatusHistoryAlreadyExistsException(String message) {
        super(message);
    }
}
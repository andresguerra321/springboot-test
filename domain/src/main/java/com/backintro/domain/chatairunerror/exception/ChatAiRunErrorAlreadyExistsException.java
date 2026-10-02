package com.backintro.domain.chatairunerror.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatAiRunErrorAlreadyExistsException extends DomainException {
    public ChatAiRunErrorAlreadyExistsException(String message) {
        super(message);
    }
}
package com.backintro.domain.chatairun.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatAiRunAlreadyExistsException extends DomainException {
    public ChatAiRunAlreadyExistsException(String message) {
        super(message);
    }
}
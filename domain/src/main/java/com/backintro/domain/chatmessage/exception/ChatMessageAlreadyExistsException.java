package com.backintro.domain.chatmessage.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatMessageAlreadyExistsException extends DomainException {
    public ChatMessageAlreadyExistsException(String message) {
        super(message);
    }
}
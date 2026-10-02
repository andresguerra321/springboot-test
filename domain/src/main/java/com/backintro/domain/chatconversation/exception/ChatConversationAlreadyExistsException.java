package com.backintro.domain.chatconversation.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatConversationAlreadyExistsException extends DomainException {
    public ChatConversationAlreadyExistsException(String message) {
        super(message);
    }
}
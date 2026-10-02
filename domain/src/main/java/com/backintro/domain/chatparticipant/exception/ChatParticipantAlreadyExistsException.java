package com.backintro.domain.chatparticipant.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatParticipantAlreadyExistsException extends DomainException {
    public ChatParticipantAlreadyExistsException(String message) {
        super(message);
    }
}
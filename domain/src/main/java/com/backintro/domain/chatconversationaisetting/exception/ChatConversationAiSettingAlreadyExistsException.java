package com.backintro.domain.chatconversationaisetting.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatConversationAiSettingAlreadyExistsException extends DomainException {
    public ChatConversationAiSettingAlreadyExistsException(String message) {
        super(message);
    }
}
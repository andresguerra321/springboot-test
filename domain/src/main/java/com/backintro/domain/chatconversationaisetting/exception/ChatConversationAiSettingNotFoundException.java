package com.backintro.domain.chatconversationaisetting.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatConversationAiSettingNotFoundException extends DomainException {
    public ChatConversationAiSettingNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatConversationAiSettingNotFoundException(String message) {
        super(message);
    }
}
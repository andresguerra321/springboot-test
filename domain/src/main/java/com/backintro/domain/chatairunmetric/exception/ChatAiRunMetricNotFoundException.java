package com.backintro.domain.chatairunmetric.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ChatAiRunMetricNotFoundException extends DomainException {
    public ChatAiRunMetricNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ChatAiRunMetricNotFoundException(String message) {
        super(message);
    }
}
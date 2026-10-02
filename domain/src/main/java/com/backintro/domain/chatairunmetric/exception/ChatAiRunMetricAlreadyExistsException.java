package com.backintro.domain.chatairunmetric.exception;

import com.backintro.domain.common.exception.DomainException;

public class ChatAiRunMetricAlreadyExistsException extends DomainException {
    public ChatAiRunMetricAlreadyExistsException(String message) {
        super(message);
    }
}
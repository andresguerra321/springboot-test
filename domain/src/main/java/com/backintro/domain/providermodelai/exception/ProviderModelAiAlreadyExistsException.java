package com.backintro.domain.providermodelai.exception;

import com.backintro.domain.common.exception.DomainException;

public class ProviderModelAiAlreadyExistsException extends DomainException {
    public ProviderModelAiAlreadyExistsException(String message) {
        super(message);
    }
}
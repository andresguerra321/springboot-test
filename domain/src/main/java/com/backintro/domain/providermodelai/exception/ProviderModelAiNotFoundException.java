package com.backintro.domain.providermodelai.exception;

import com.backintro.domain.common.exception.DomainException;
import java.util.UUID;

public class ProviderModelAiNotFoundException extends DomainException {
    public ProviderModelAiNotFoundException(UUID id) {
        super("No se encontro el registro con el identificador: " + id);
    }
    public ProviderModelAiNotFoundException(String message) {
        super(message);
    }
}
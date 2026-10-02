package com.backintro.application.documenttype.command;

import java.util.Objects;

import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public record UpdateDocumentTypeCommand(
        DocumentTypeId id,
        String code,
        String name
) {

    public UpdateDocumentTypeCommand {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(code, "code must not be null");
        Objects.requireNonNull(name, "name must not be null");
    }
}
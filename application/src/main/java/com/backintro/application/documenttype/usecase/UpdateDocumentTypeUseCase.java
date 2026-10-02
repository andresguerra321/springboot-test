package com.backintro.application.documenttype.usecase;

import com.backintro.application.documenttype.command.UpdateDocumentTypeCommand;
import com.backintro.application.documenttype.dto.DocumentTypeResponse;
import com.backintro.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;

public class UpdateDocumentTypeUseCase {

    private final DocumentTypeRepository repository;

    public UpdateDocumentTypeUseCase(
            DocumentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public DocumentTypeResponse execute(
            UpdateDocumentTypeCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new DocumentTypeNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.code(),
                command.name()
        );

        var updated =
                repository.save(entity);

        return new DocumentTypeResponse(
                updated.id().value(),
                updated.code(),
                updated.name(),
                updated.active(),
                null,
                null
        );
    }
}
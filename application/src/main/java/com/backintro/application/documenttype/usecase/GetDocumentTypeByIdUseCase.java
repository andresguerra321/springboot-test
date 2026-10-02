package com.backintro.application.documenttype.usecase;

import com.backintro.application.documenttype.dto.DocumentTypeResponse;
import com.backintro.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;

public class GetDocumentTypeByIdUseCase {

    private final DocumentTypeRepository repository;

    public GetDocumentTypeByIdUseCase(
            DocumentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public DocumentTypeResponse execute(
            DocumentTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new DocumentTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new DocumentTypeResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                null,
                null
        );
    }
}
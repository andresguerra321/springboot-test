package com.backintro.application.documenttype.usecase;

import java.util.List;

import com.backintro.application.documenttype.dto.DocumentTypeResponse;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;

public class ListDocumentTypeUseCase {

    private final DocumentTypeRepository repository;

    public ListDocumentTypeUseCase(
            DocumentTypeRepository repository
    ) {
        this.repository = repository;
    }

    public List<DocumentTypeResponse> execute() {

        return repository.findAll()
                .stream()
                .map(entity ->
                        new DocumentTypeResponse(
                entity.id().value(),
                entity.code(),
                entity.name(),
                entity.active(),
                null,
                null
                        )
                )
                .toList();
    }
}
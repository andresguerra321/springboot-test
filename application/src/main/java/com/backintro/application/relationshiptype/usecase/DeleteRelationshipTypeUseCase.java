package com.backintro.application.relationshiptype.usecase;

import java.time.LocalDateTime;

import com.backintro.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.backintro.domain.relationshiptype.event.RelationshipTypeDeletedEvent;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class DeleteRelationshipTypeUseCase {

    private final RelationshipTypeRepository repository;

    public DeleteRelationshipTypeUseCase(
            RelationshipTypeRepository repository
    ) {
        this.repository = repository;
    }

    public RelationshipTypeDeletedEvent execute(
            RelationshipTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RelationshipTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        repository.delete(entity);

        return new RelationshipTypeDeletedEvent(
                id,
                LocalDateTime.now()
        );
    }
}
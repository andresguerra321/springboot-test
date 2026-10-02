package com.backintro.application.relationshiptype.usecase;

import com.backintro.application.relationshiptype.dto.RelationshipTypeResponse;
import com.backintro.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class GetRelationshipTypeByIdUseCase {

    private final RelationshipTypeRepository repository;

    public GetRelationshipTypeByIdUseCase(
            RelationshipTypeRepository repository
    ) {
        this.repository = repository;
    }

    public RelationshipTypeResponse execute(
            RelationshipTypeId id
    ) {

        var entity =
                repository.findById(id)
                        .orElseThrow(() ->
                                new RelationshipTypeNotFoundApplicationException(
                                        id.value().toString()
                                )
                        );

        return new RelationshipTypeResponse(
                entity.id().value(),
                entity.description()
        );
    }
}
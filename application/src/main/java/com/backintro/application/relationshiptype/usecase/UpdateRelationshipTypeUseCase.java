package com.backintro.application.relationshiptype.usecase;

import com.backintro.application.relationshiptype.command.UpdateRelationshipTypeCommand;
import com.backintro.application.relationshiptype.dto.RelationshipTypeResponse;
import com.backintro.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class UpdateRelationshipTypeUseCase {

    private final RelationshipTypeRepository repository;

    public UpdateRelationshipTypeUseCase(
            RelationshipTypeRepository repository
    ) {
        this.repository = repository;
    }

    public RelationshipTypeResponse execute(
            UpdateRelationshipTypeCommand command
    ) {

        var entity =
                repository.findById(command.id())
                        .orElseThrow(() ->
                                new RelationshipTypeNotFoundApplicationException(
                                        command.id()
                                                .value()
                                                .toString()
                                )
                        );

        entity.update(
                command.description()
        );

        var updated =
                repository.save(entity);

        return new RelationshipTypeResponse(
                updated.id().value(),
                updated.description()
        );
    }
}
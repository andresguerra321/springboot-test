package com.backintro.application.relationshiptype.usecase;

import com.backintro.application.relationshiptype.command.RegisterRelationshipTypeCommand;
import com.backintro.application.relationshiptype.dto.RelationshipTypeResponse;
import com.backintro.domain.relationshiptype.model.aggregate.RelationshipType;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class RegisterRelationshipTypeUseCase {

    private final RelationshipTypeRepository repository;

    public RegisterRelationshipTypeUseCase(
            RelationshipTypeRepository repository
    ) {
        this.repository = repository;
    }

    public RelationshipTypeResponse execute(
            RegisterRelationshipTypeCommand command
    ) {

        RelationshipType entity = RelationshipType.register(
                command.description()
        );

        RelationshipType saved =
                repository.save(entity);

        return new RelationshipTypeResponse(
                saved.id().value(),
                saved.description()
        );
    }
}
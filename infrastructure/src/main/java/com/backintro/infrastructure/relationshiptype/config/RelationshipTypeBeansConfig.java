package com.backintro.infrastructure.relationshiptype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.relationshiptype.usecase.DeleteRelationshipTypeUseCase;
import com.backintro.application.relationshiptype.usecase.GetRelationshipTypeByIdUseCase;
import com.backintro.application.relationshiptype.usecase.ListRelationshipTypeUseCase;
import com.backintro.application.relationshiptype.usecase.RegisterRelationshipTypeUseCase;
import com.backintro.application.relationshiptype.usecase.UpdateRelationshipTypeUseCase;
import com.backintro.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypePersistenceMapper;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.repositories.RelationshipTypeJpaRepository;
import com.backintro.infrastructure.relationshiptype.adapters.out.persistence.repositories.RelationshipTypeRepositoryAdapter;

@Configuration
public class RelationshipTypeBeansConfig {

    @Bean
    public RelationshipTypePersistenceMapper relationshiptypePersistenceMapper() {
        return new RelationshipTypePersistenceMapper();
    }

    @Bean
    public RelationshipTypeRepository relationshiptypeRepository(RelationshipTypeJpaRepository repository, RelationshipTypePersistenceMapper mapper) {
        return new RelationshipTypeRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterRelationshipTypeUseCase registerRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new RegisterRelationshipTypeUseCase(
                repository
        );
    }

    @Bean
    public GetRelationshipTypeByIdUseCase getRelationshipTypeByIdUseCase(RelationshipTypeRepository repository) {
        return new GetRelationshipTypeByIdUseCase(
                repository
        );
    }

    @Bean
    public ListRelationshipTypeUseCase listRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new ListRelationshipTypeUseCase(
                repository
        );
    }

    @Bean
    public UpdateRelationshipTypeUseCase updateRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new UpdateRelationshipTypeUseCase(
                repository
        );
    }

    @Bean
    public DeleteRelationshipTypeUseCase deleteRelationshipTypeUseCase(RelationshipTypeRepository repository) {
        return new DeleteRelationshipTypeUseCase(
                repository
        );
    }
}
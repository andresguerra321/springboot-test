package com.backintro.infrastructure.treatmentgoal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentgoal.usecase.DeleteTreatmentGoalUseCase;
import com.backintro.application.treatmentgoal.usecase.GetTreatmentGoalByIdUseCase;
import com.backintro.application.treatmentgoal.usecase.ListTreatmentGoalUseCase;
import com.backintro.application.treatmentgoal.usecase.RegisterTreatmentGoalUseCase;
import com.backintro.application.treatmentgoal.usecase.UpdateTreatmentGoalUseCase;
import com.backintro.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalPersistenceMapper;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories.TreatmentGoalJpaRepository;
import com.backintro.infrastructure.treatmentgoal.adapters.out.persistence.repositories.TreatmentGoalRepositoryAdapter;

@Configuration
public class TreatmentGoalBeansConfig {

    @Bean
    public TreatmentGoalPersistenceMapper treatmentgoalPersistenceMapper() {
        return new TreatmentGoalPersistenceMapper();
    }

    @Bean
    public TreatmentGoalRepository treatmentgoalRepository(TreatmentGoalJpaRepository repository, TreatmentGoalPersistenceMapper mapper) {
        return new TreatmentGoalRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentGoalUseCase registerTreatmentGoalUseCase(TreatmentGoalRepository repository, com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new RegisterTreatmentGoalUseCase(repository, treatmentGoalStatusRepository);
    }

    @Bean
    public GetTreatmentGoalByIdUseCase getTreatmentGoalByIdUseCase(TreatmentGoalRepository repository, com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new GetTreatmentGoalByIdUseCase(repository, treatmentGoalStatusRepository);
    }

    @Bean
    public ListTreatmentGoalUseCase listTreatmentGoalUseCase(TreatmentGoalRepository repository, com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new ListTreatmentGoalUseCase(repository, treatmentGoalStatusRepository);
    }

    @Bean
    public UpdateTreatmentGoalUseCase updateTreatmentGoalUseCase(TreatmentGoalRepository repository, com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        return new UpdateTreatmentGoalUseCase(repository, treatmentGoalStatusRepository);
    }

    @Bean
    public DeleteTreatmentGoalUseCase deleteTreatmentGoalUseCase(TreatmentGoalRepository repository) {
        return new DeleteTreatmentGoalUseCase(repository);
    }
}
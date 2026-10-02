package com.backintro.infrastructure.treatmentgoalstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentgoalstatus.usecase.DeleteTreatmentGoalStatusUseCase;
import com.backintro.application.treatmentgoalstatus.usecase.GetTreatmentGoalStatusByIdUseCase;
import com.backintro.application.treatmentgoalstatus.usecase.ListTreatmentGoalStatusUseCase;
import com.backintro.application.treatmentgoalstatus.usecase.RegisterTreatmentGoalStatusUseCase;
import com.backintro.application.treatmentgoalstatus.usecase.UpdateTreatmentGoalStatusUseCase;
import com.backintro.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;
import com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.mappers.TreatmentGoalStatusPersistenceMapper;
import com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.repositories.TreatmentGoalStatusJpaRepository;
import com.backintro.infrastructure.treatmentgoalstatus.adapters.out.persistence.repositories.TreatmentGoalStatusRepositoryAdapter;

@Configuration
public class TreatmentGoalStatusBeansConfig {

    @Bean
    public TreatmentGoalStatusPersistenceMapper treatmentgoalstatusPersistenceMapper() {
        return new TreatmentGoalStatusPersistenceMapper();
    }

    @Bean
    public TreatmentGoalStatusRepository treatmentgoalstatusRepository(TreatmentGoalStatusJpaRepository repository, TreatmentGoalStatusPersistenceMapper mapper) {
        return new TreatmentGoalStatusRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterTreatmentGoalStatusUseCase registerTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new RegisterTreatmentGoalStatusUseCase(
                repository
        );
    }

    @Bean
    public GetTreatmentGoalStatusByIdUseCase getTreatmentGoalStatusByIdUseCase(TreatmentGoalStatusRepository repository) {
        return new GetTreatmentGoalStatusByIdUseCase(
                repository
        );
    }

    @Bean
    public ListTreatmentGoalStatusUseCase listTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new ListTreatmentGoalStatusUseCase(
                repository
        );
    }

    @Bean
    public UpdateTreatmentGoalStatusUseCase updateTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new UpdateTreatmentGoalStatusUseCase(
                repository
        );
    }

    @Bean
    public DeleteTreatmentGoalStatusUseCase deleteTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository repository) {
        return new DeleteTreatmentGoalStatusUseCase(
                repository
        );
    }
}
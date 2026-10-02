package com.backintro.infrastructure.treatmentstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentstatus.usecase.DeleteTreatmentStatusUseCase;
import com.backintro.application.treatmentstatus.usecase.GetTreatmentStatusByIdUseCase;
import com.backintro.application.treatmentstatus.usecase.ListTreatmentStatusUseCase;
import com.backintro.application.treatmentstatus.usecase.RegisterTreatmentStatusUseCase;
import com.backintro.application.treatmentstatus.usecase.UpdateTreatmentStatusUseCase;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.mappers.TreatmentStatusPersistenceMapper;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.repositories.TreatmentStatusJpaRepository;
import com.backintro.infrastructure.treatmentstatus.adapters.out.persistence.repositories.TreatmentStatusRepositoryAdapter;

@Configuration
public class TreatmentStatusBeansConfig {

    @Bean
    public TreatmentStatusPersistenceMapper treatmentstatusPersistenceMapper() {
        return new TreatmentStatusPersistenceMapper();
    }

    @Bean
    public TreatmentStatusRepository treatmentstatusRepository(TreatmentStatusJpaRepository repository, TreatmentStatusPersistenceMapper mapper) {
        return new TreatmentStatusRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterTreatmentStatusUseCase registerTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new RegisterTreatmentStatusUseCase(
                repository
        );
    }

    @Bean
    public GetTreatmentStatusByIdUseCase getTreatmentStatusByIdUseCase(TreatmentStatusRepository repository) {
        return new GetTreatmentStatusByIdUseCase(
                repository
        );
    }

    @Bean
    public ListTreatmentStatusUseCase listTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new ListTreatmentStatusUseCase(
                repository
        );
    }

    @Bean
    public UpdateTreatmentStatusUseCase updateTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new UpdateTreatmentStatusUseCase(
                repository
        );
    }

    @Bean
    public DeleteTreatmentStatusUseCase deleteTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        return new DeleteTreatmentStatusUseCase(
                repository
        );
    }
}
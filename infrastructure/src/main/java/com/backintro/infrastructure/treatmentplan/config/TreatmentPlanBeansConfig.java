package com.backintro.infrastructure.treatmentplan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.treatmentplan.usecase.DeleteTreatmentPlanUseCase;
import com.backintro.application.treatmentplan.usecase.GetTreatmentPlanByIdUseCase;
import com.backintro.application.treatmentplan.usecase.ListTreatmentPlanUseCase;
import com.backintro.application.treatmentplan.usecase.RegisterTreatmentPlanUseCase;
import com.backintro.application.treatmentplan.usecase.UpdateTreatmentPlanUseCase;
import com.backintro.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.mappers.TreatmentPlanPersistenceMapper;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.repositories.TreatmentPlanJpaRepository;
import com.backintro.infrastructure.treatmentplan.adapters.out.persistence.repositories.TreatmentPlanRepositoryAdapter;

@Configuration
public class TreatmentPlanBeansConfig {

    @Bean
    public TreatmentPlanPersistenceMapper treatmentplanPersistenceMapper() {
        return new TreatmentPlanPersistenceMapper();
    }

    @Bean
    public TreatmentPlanRepository treatmentplanRepository(TreatmentPlanJpaRepository repository, TreatmentPlanPersistenceMapper mapper) {
        return new TreatmentPlanRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterTreatmentPlanUseCase registerTreatmentPlanUseCase(TreatmentPlanRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository treatmentStatusRepository) {
        return new RegisterTreatmentPlanUseCase(repository, professionalRepository, treatmentStatusRepository);
    }

    @Bean
    public GetTreatmentPlanByIdUseCase getTreatmentPlanByIdUseCase(TreatmentPlanRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository treatmentStatusRepository) {
        return new GetTreatmentPlanByIdUseCase(repository, professionalRepository, treatmentStatusRepository);
    }

    @Bean
    public ListTreatmentPlanUseCase listTreatmentPlanUseCase(TreatmentPlanRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository treatmentStatusRepository) {
        return new ListTreatmentPlanUseCase(repository, professionalRepository, treatmentStatusRepository);
    }

    @Bean
    public UpdateTreatmentPlanUseCase updateTreatmentPlanUseCase(TreatmentPlanRepository repository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository treatmentStatusRepository) {
        return new UpdateTreatmentPlanUseCase(repository, professionalRepository, treatmentStatusRepository);
    }

    @Bean
    public DeleteTreatmentPlanUseCase deleteTreatmentPlanUseCase(TreatmentPlanRepository repository) {
        return new DeleteTreatmentPlanUseCase(repository);
    }
}
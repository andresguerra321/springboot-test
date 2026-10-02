package com.backintro.infrastructure.riskassessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.riskassessment.usecase.DeleteRiskAssessmentUseCase;
import com.backintro.application.riskassessment.usecase.GetRiskAssessmentByIdUseCase;
import com.backintro.application.riskassessment.usecase.ListRiskAssessmentUseCase;
import com.backintro.application.riskassessment.usecase.RegisterRiskAssessmentUseCase;
import com.backintro.application.riskassessment.usecase.UpdateRiskAssessmentUseCase;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.repositories.RiskAssessmentJpaRepository;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.repositories.RiskAssessmentRepositoryAdapter;

@Configuration
public class RiskAssessmentBeansConfig {

    @Bean
    public RiskAssessmentPersistenceMapper riskassessmentPersistenceMapper() {
        return new RiskAssessmentPersistenceMapper();
    }

    @Bean
    public RiskAssessmentRepository riskassessmentRepository(RiskAssessmentJpaRepository repository, RiskAssessmentPersistenceMapper mapper) {
        return new RiskAssessmentRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterRiskAssessmentUseCase registerRiskAssessmentUseCase(RiskAssessmentRepository repository, com.backintro.domain.risklevel.port.repository.RiskLevelRepository riskLevelRepository) {
        return new RegisterRiskAssessmentUseCase(repository, riskLevelRepository);
    }

    @Bean
    public GetRiskAssessmentByIdUseCase getRiskAssessmentByIdUseCase(RiskAssessmentRepository repository, com.backintro.domain.risklevel.port.repository.RiskLevelRepository riskLevelRepository) {
        return new GetRiskAssessmentByIdUseCase(repository, riskLevelRepository);
    }

    @Bean
    public ListRiskAssessmentUseCase listRiskAssessmentUseCase(RiskAssessmentRepository repository, com.backintro.domain.risklevel.port.repository.RiskLevelRepository riskLevelRepository) {
        return new ListRiskAssessmentUseCase(repository, riskLevelRepository);
    }

    @Bean
    public UpdateRiskAssessmentUseCase updateRiskAssessmentUseCase(RiskAssessmentRepository repository, com.backintro.domain.risklevel.port.repository.RiskLevelRepository riskLevelRepository) {
        return new UpdateRiskAssessmentUseCase(repository, riskLevelRepository);
    }

    @Bean
    public DeleteRiskAssessmentUseCase deleteRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new DeleteRiskAssessmentUseCase(repository);
    }
}
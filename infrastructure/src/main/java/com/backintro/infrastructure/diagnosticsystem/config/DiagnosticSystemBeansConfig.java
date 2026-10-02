package com.backintro.infrastructure.diagnosticsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.diagnosticsystem.usecase.DeleteDiagnosticSystemUseCase;
import com.backintro.application.diagnosticsystem.usecase.GetDiagnosticSystemByIdUseCase;
import com.backintro.application.diagnosticsystem.usecase.ListDiagnosticSystemUseCase;
import com.backintro.application.diagnosticsystem.usecase.RegisterDiagnosticSystemUseCase;
import com.backintro.application.diagnosticsystem.usecase.UpdateDiagnosticSystemUseCase;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.mappers.DiagnosticSystemPersistenceMapper;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.repositories.DiagnosticSystemJpaRepository;
import com.backintro.infrastructure.diagnosticsystem.adapters.out.persistence.repositories.DiagnosticSystemRepositoryAdapter;

@Configuration
public class DiagnosticSystemBeansConfig {

    @Bean
    public DiagnosticSystemPersistenceMapper diagnosticsystemPersistenceMapper() {
        return new DiagnosticSystemPersistenceMapper();
    }

    @Bean
    public DiagnosticSystemRepository diagnosticsystemRepository(DiagnosticSystemJpaRepository repository, DiagnosticSystemPersistenceMapper mapper) {
        return new DiagnosticSystemRepositoryAdapter(
                repository,
                mapper
        );
    }

    @Bean
    public RegisterDiagnosticSystemUseCase registerDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new RegisterDiagnosticSystemUseCase(
                repository
        );
    }

    @Bean
    public GetDiagnosticSystemByIdUseCase getDiagnosticSystemByIdUseCase(DiagnosticSystemRepository repository) {
        return new GetDiagnosticSystemByIdUseCase(
                repository
        );
    }

    @Bean
    public ListDiagnosticSystemUseCase listDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new ListDiagnosticSystemUseCase(
                repository
        );
    }

    @Bean
    public UpdateDiagnosticSystemUseCase updateDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new UpdateDiagnosticSystemUseCase(
                repository
        );
    }

    @Bean
    public DeleteDiagnosticSystemUseCase deleteDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        return new DeleteDiagnosticSystemUseCase(
                repository
        );
    }
}
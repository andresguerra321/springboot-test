package com.backintro.infrastructure.empresa.config;

import com.backintro.application.empresa.usecase.DeleteEmpresaUseCase;
import com.backintro.application.empresa.usecase.GetEmpresaByIdUseCase;
import com.backintro.application.empresa.usecase.ListEmpresaUseCase;
import com.backintro.application.empresa.usecase.RegisterEmpresaUseCase;
import com.backintro.application.empresa.usecase.UpdateEmpresaUseCase;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de beans de Spring para registrar los Casos de Uso de la capa de Aplicación
 * sin necesidad de contaminar dicha capa con anotaciones de Spring.
 */
@Configuration
public class EmpresaBeansConfig {

    @Bean
    public RegisterEmpresaUseCase registerEmpresaUseCase(EmpresaRepository empresaRepository) {
        return new RegisterEmpresaUseCase(empresaRepository);
    }

    @Bean
    public GetEmpresaByIdUseCase getEmpresaByIdUseCase(EmpresaRepository empresaRepository) {
        return new GetEmpresaByIdUseCase(empresaRepository);
    }

    @Bean
    public ListEmpresaUseCase listEmpresaUseCase(EmpresaRepository empresaRepository) {
        return new ListEmpresaUseCase(empresaRepository);
    }

    @Bean
    public UpdateEmpresaUseCase updateEmpresaUseCase(EmpresaRepository empresaRepository) {
        return new UpdateEmpresaUseCase(empresaRepository);
    }

    @Bean
    public DeleteEmpresaUseCase deleteEmpresaUseCase(EmpresaRepository empresaRepository) {
        return new DeleteEmpresaUseCase(empresaRepository);
    }
}

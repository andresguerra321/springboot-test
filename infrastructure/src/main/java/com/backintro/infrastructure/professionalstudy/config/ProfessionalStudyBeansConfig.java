package com.backintro.infrastructure.professionalstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.professionalstudy.usecase.DeleteProfessionalStudyUseCase;
import com.backintro.application.professionalstudy.usecase.GetProfessionalStudyByIdUseCase;
import com.backintro.application.professionalstudy.usecase.ListProfessionalStudyUseCase;
import com.backintro.application.professionalstudy.usecase.RegisterProfessionalStudyUseCase;
import com.backintro.application.professionalstudy.usecase.UpdateProfessionalStudyUseCase;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyPersistenceMapper;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories.ProfessionalStudyJpaRepository;
import com.backintro.infrastructure.professionalstudy.adapters.out.persistence.repositories.ProfessionalStudyRepositoryAdapter;

@Configuration
public class ProfessionalStudyBeansConfig {

    @Bean
    public ProfessionalStudyPersistenceMapper professionalstudyPersistenceMapper() {
        return new ProfessionalStudyPersistenceMapper();
    }

    @Bean
    public ProfessionalStudyRepository professionalstudyRepository(ProfessionalStudyJpaRepository repository, ProfessionalStudyPersistenceMapper mapper) {
        return new ProfessionalStudyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProfessionalStudyUseCase registerProfessionalStudyUseCase(ProfessionalStudyRepository repository, com.backintro.domain.study.port.repository.StudyRepository studyRepository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new RegisterProfessionalStudyUseCase(repository, studyRepository, professionalRepository, countryRepository);
    }

    @Bean
    public GetProfessionalStudyByIdUseCase getProfessionalStudyByIdUseCase(ProfessionalStudyRepository repository, com.backintro.domain.study.port.repository.StudyRepository studyRepository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new GetProfessionalStudyByIdUseCase(repository, studyRepository, professionalRepository, countryRepository);
    }

    @Bean
    public ListProfessionalStudyUseCase listProfessionalStudyUseCase(ProfessionalStudyRepository repository, com.backintro.domain.study.port.repository.StudyRepository studyRepository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new ListProfessionalStudyUseCase(repository, studyRepository, professionalRepository, countryRepository);
    }

    @Bean
    public UpdateProfessionalStudyUseCase updateProfessionalStudyUseCase(ProfessionalStudyRepository repository, com.backintro.domain.study.port.repository.StudyRepository studyRepository, com.backintro.domain.professional.port.repository.ProfessionalRepository professionalRepository, com.backintro.domain.country.port.repository.CountryRepository countryRepository) {
        return new UpdateProfessionalStudyUseCase(repository, studyRepository, professionalRepository, countryRepository);
    }

    @Bean
    public DeleteProfessionalStudyUseCase deleteProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        return new DeleteProfessionalStudyUseCase(repository);
    }
}
package com.backintro.domain.assessmenttype.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.assessmenttype.model.aggregate.AssessmentType;
import com.backintro.domain.assessmenttype.model.valueobject.AssessmentTypeId;

public interface AssessmentTypeRepository {
    AssessmentType save(AssessmentType entity);

    Optional<AssessmentType> findById(AssessmentTypeId id);

    List<AssessmentType> findAll();

    boolean existsByCode(String code);

    void delete(AssessmentType entity);
}
package com.backintro.domain.diagnosticsystem.port.repository;

import java.util.List;
import java.util.Optional;

import com.backintro.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public interface DiagnosticSystemRepository {
    DiagnosticSystem save(DiagnosticSystem entity);

    Optional<DiagnosticSystem> findById(DiagnosticSystemId id);

    List<DiagnosticSystem> findAll();

    boolean existsByCode(String code);

    void delete(DiagnosticSystem entity);
}
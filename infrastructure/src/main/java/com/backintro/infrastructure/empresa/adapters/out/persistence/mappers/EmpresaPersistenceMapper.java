package com.backintro.infrastructure.empresa.adapters.out.persistence.mappers;

import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.Nit;
import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaJpaEntity;
import org.springframework.stereotype.Component;

/**
 * Mapper manual para convertir entre el agregado Empresa y la entidad EmpresaJpaEntity.
 */
@Component
public class EmpresaPersistenceMapper {

    public Empresa toDomain(EmpresaJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        Nit nitObj = entity.getNit() != null ? new Nit(entity.getNit()) : null;

        return new Empresa(
                entity.getId(),
                entity.getNombre(),
                nitObj,
                entity.getActiva(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public EmpresaJpaEntity toJpaEntity(Empresa domain) {
        if (domain == null) {
            return null;
        }

        String nitValue = domain.getNit() != null ? domain.getNit().getValue() : null;

        return new EmpresaJpaEntity(
                domain.getId(),
                domain.getNombre(),
                nitValue,
                domain.getActiva(),
                domain.getCreatedAt(),
                domain.getUpdatedAt()
        );
    }
}

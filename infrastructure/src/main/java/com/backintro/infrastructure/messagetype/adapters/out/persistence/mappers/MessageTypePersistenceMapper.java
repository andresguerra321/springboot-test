package com.backintro.infrastructure.messagetype.adapters.out.persistence.mappers;

import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeJpaEntity;

public class MessageTypePersistenceMapper {

    public MessageTypeJpaEntity toJpa(MessageType domain) {
        if (domain == null) return null;
        MessageTypeJpaEntity jpa = new MessageTypeJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameType(domain.nameType());
        return jpa;
    }

    public MessageType toDomain(MessageTypeJpaEntity jpa) {
        if (jpa == null) return null;
        return MessageType.restore(
                new MessageTypeId(jpa.getId()),
                jpa.getNameType()
        );
    }
}
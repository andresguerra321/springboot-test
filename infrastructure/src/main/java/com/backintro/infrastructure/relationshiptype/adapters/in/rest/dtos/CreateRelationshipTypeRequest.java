package com.backintro.infrastructure.relationshiptype.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateRelationshipTypeRequest(

        @NotBlank(message = "description is required")
        String description

) {
}
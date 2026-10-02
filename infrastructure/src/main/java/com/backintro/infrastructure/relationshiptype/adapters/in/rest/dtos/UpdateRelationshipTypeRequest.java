package com.backintro.infrastructure.relationshiptype.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateRelationshipTypeRequest(

        @NotBlank(message = "description is required")
        String description

) {
}
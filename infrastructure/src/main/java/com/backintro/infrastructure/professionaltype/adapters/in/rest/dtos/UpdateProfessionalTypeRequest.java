package com.backintro.infrastructure.professionaltype.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateProfessionalTypeRequest(

        @NotBlank(message = "name is required")
        String name

) {
}
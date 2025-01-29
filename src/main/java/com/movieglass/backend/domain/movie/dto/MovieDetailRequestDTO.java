package com.movieglass.backend.domain.movie.dto;

import jakarta.validation.constraints.NotBlank;

public record MovieDetailRequestDTO(
        @NotBlank Long movieId
) {}

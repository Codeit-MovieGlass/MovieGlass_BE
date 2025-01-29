package com.movieglass.backend.domain.movie.dto;

public record MovieDetailResponseDTO(
        Long id,
        String movieName,
        String productionYear,
        String productionType,
        String productionLength,
        String productionGenre,
        String productionCountry,
        String productionPlot,
        String productionImage,
        String horizontalImage,
        String trailerUrl // 새 필드 추가
) {}

package com.movieglass.backend.domain.home.dto;

import com.movieglass.backend.domain.curation.entity.Curation;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class CurationMoviesDto {
    private final String curationId;
    private final String curationName;
    private final List<MovieSummaryDto> movies;

    public static CurationMoviesDto from(Curation curation) {
        return CurationMoviesDto.builder()
                .curationId(curation.getId())
                .curationName(curation.getName())
                .movies(curation.getCurationMovies().stream()
                        .map(curationMovie -> MovieSummaryDto.from(curationMovie.getMovie()))
                        .collect(Collectors.toList()))
                .build();
    }
}

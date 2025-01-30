package com.movieglass.backend.domain.home.dto.response;

import com.movieglass.backend.domain.home.dto.CurationMoviesDto;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class CurationShuffleResponseDto {
    private final List<CurationMoviesDto> curations;

    public static CurationShuffleResponseDto of(List<CurationMoviesDto> curations) {
        return CurationShuffleResponseDto.builder()
                .curations(curations)
                .build();
    }
}

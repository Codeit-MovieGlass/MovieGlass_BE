package com.movieglass.backend.domain.home.service;

import com.movieglass.backend.domain.curation.repository.CurationRepository;
import com.movieglass.backend.domain.home.dto.CurationMoviesDto;
import com.movieglass.backend.domain.movie.repository.MovieRepository;
import com.movieglass.backend.domain.home.dto.HomeResponseDto;
import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.curation.entity.Curation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final MovieRepository movieRepository;
    private final CurationRepository curationRepository;

    @Override
    public HomeResponseDto getHomeData(String userId) {
        // TODO: 추천 로직이 확정되면 recommendation 테이블을 활용하도록 변경
        List<Movie> top10Movies = List.of(
                movieRepository.findById(1L).orElse(null),
                movieRepository.findById(2L).orElse(null),
                movieRepository.findById(3L).orElse(null),
                movieRepository.findById(4L).orElse(null),
                movieRepository.findById(5L).orElse(null),
                movieRepository.findById(6L).orElse(null),
                movieRepository.findById(7L).orElse(null),
                movieRepository.findById(8L).orElse(null),
                movieRepository.findById(9L).orElse(null),
                movieRepository.findById(10L).orElse(null)
        ).stream().filter(Objects::nonNull).toList();

        // 날씨 큐레이션 조회
        List<CurationMoviesDto> weatherCurations = curationRepository.findByDescription("weather").stream() // TODO: 날씨 정보를 받아서 조회하도록 변경
                .map(CurationMoviesDto::from)
                .toList();

        // 기타 큐레이션 조회
        List<CurationMoviesDto> otherCurations = curationRepository.findByDescription("other").stream()
                .map(CurationMoviesDto::from)
                .toList();

        return HomeResponseDto.of(top10Movies, weatherCurations, otherCurations);
    }

}


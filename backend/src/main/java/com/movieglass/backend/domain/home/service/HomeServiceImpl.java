package com.movieglass.backend.domain.home.service;

import com.movieglass.backend.domain.curation.repository.CurationRepository;
import com.movieglass.backend.domain.movie.repository.MovieRepository;
import com.movieglass.backend.domain.home.dto.HomeResponseDto;
import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.curation.entity.Curation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final MovieRepository movieRepository;
    private final CurationRepository curationRepository;

    @Override
    public HomeResponseDto getHomeData(String userId) {
        // TODO: 추천 로직이 확정되면 recommendation 테이블을 활용하도록 변경
        List<Movie> top10Movies = List.of(
                movieRepository.findById("KMDb001").orElse(null),
                movieRepository.findById("KMDb002").orElse(null),
                movieRepository.findById("KMDb003").orElse(null),
                movieRepository.findById("KMDb004").orElse(null),
                movieRepository.findById("KMDb005").orElse(null),
                movieRepository.findById("KMDb006").orElse(null),
                movieRepository.findById("KMDb007").orElse(null),
                movieRepository.findById("KMDb008").orElse(null),
                movieRepository.findById("KMDb009").orElse(null),
                movieRepository.findById("KMDb010").orElse(null)
        ).stream().filter(Objects::nonNull).collect(Collectors.toList());

        // 날씨 큐레이션 조회 (description 기반으로 검색)
        List<Curation> weatherCurations = curationRepository.findByDescription("weather");

        // 기타 큐레이션 조회
        List<Curation> otherCurations = curationRepository.findByDescription("other");

        return HomeResponseDto.of(top10Movies, weatherCurations, otherCurations);
    }
}

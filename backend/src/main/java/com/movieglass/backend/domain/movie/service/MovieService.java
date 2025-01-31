package com.movieglass.backend.domain.movie.service;

import com.movieglass.backend.domain.movie.converter.MovieConverter;
import com.movieglass.backend.domain.movie.dto.MovieDetailResponseDTO;
import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;

    //private static final String YOUTUBE_API_KEY = "AIzaSyBxrnQk_8Vu4ZF79_JqKnzl8vg7IgHoxHU";
    private static final String YOUTUBE_API_KEY = "AIzaSyB4t9kWex0U0LPEv8_jWWClPv-S3DGnQ-w";
    private static final String YOUTUBE_SEARCH_URL = "https://www.googleapis.com/youtube/v3/search";

    public MovieDetailResponseDTO getMovieDetails(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // 예고편 URL이 없으면 YouTube API로 가져오기
        if (movie.getTrailerUrl() == null) {
            String trailerUrl = fetchTrailerUrl(movie.getMovieName());
            movie.setTrailerUrl(trailerUrl);
            movieRepository.save(movie); // 업데이트된 값 저장
        }

        return movieConverter.toDetailResponseDTO(movie);
    }

    private String fetchTrailerUrl(String movieName) {
        RestTemplate restTemplate = new RestTemplate();
        String query = movieName + " trailer";

        String url = YOUTUBE_SEARCH_URL +
                "?part=snippet" +
                "&q=" + query +
                "&key=" + YOUTUBE_API_KEY +
                "&type=video" +
                "&maxResults=1";

        try {
            var response = restTemplate.getForObject(url, Map.class);
            var items = (List<Map<String, Object>>) response.get("items");

            if (items != null && !items.isEmpty()) {
                Map<String, Object> firstItem = items.get(0);
                Map<String, Object> id = (Map<String, Object>) firstItem.get("id");
                return "https://www.youtube.com/watch?v=" + id.get("videoId");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // 예고편이 없으면 null 반환
    }
}



//@Service
//@RequiredArgsConstructor
//public class MovieService {
//
//    private final MovieRepository movieRepository;
//    private final MovieConverter movieConverter;
//
//    public MovieDetailResponseDTO getMovieDetails(String movieId) {
//        Movie movie = movieRepository.findById(movieId)
//                .orElseThrow(() -> new RuntimeException("Movie not found"));
//        return movieConverter.toDetailResponseDTO(movie);
//    }
//}

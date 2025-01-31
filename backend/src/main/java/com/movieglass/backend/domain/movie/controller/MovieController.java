package com.movieglass.backend.domain.movie.controller;

import com.movieglass.backend.domain.movie.dto.MovieDetailResponseDTO;
import com.movieglass.backend.domain.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDetailResponseDTO> getMovieDetails(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getMovieDetails(movieId));
    }

//    @GetMapping("/{movieId}")
//    public ResponseEntity<MovieDetailResponseDTO> getMovieDetails(@PathVariable String movieId) {
//        return ResponseEntity.ok(movieService.getMovieDetails(movieId));
//    }
}

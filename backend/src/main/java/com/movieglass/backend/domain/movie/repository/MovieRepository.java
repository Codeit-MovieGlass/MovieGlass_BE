package com.movieglass.backend.domain.movie.repository;

import com.movieglass.backend.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByMovieNameContainingIgnoreCaseOrProductionGenreContainingIgnoreCaseOrProductionKeywordContainingIgnoreCase(
            String movieName, String productionGenre, String productionKeyword);
}

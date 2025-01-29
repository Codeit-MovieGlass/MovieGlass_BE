package com.movieglass.backend.domain.movie.repository;

import com.movieglass.backend.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}

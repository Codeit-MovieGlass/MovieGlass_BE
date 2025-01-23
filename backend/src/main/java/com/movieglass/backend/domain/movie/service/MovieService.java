package com.movieglass.backend.domain.movie.service;

import com.movieglass.backend.domain.movie.entity.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
}

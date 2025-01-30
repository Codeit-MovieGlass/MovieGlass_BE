package com.movieglass.backend.domain.home.service;

import com.movieglass.backend.domain.home.dto.response.MovieSearchResponseDto;

public interface MovieSearchService {
    MovieSearchResponseDto searchMovies(String query);
}
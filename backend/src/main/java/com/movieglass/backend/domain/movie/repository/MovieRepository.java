package com.movieglass.backend.domain.movie.repository;

import com.movieglass.backend.domain.movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // 영화 제목, 인물, 장르, 키워드에서 검색어가 포함된 영화 조회
    List<Movie> findByMovieNameContainingIgnoreCaseOrProductionGenreContainingIgnoreCaseOrProductionKeywordContainingIgnoreCase(
            String movieName, String productionGenre, String productionKeyword);
}

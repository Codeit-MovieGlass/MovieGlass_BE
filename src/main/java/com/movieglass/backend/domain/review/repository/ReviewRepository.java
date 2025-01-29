package com.movieglass.backend.domain.review.repository;

import com.movieglass.backend.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);
    Optional<Review> findByIdAndMovieId(Long reviewId, Long movieId);
}

package com.movieglass.backend.domain.review.controller;

import com.movieglass.backend.domain.review.dto.ReviewRequestDto;
import com.movieglass.backend.domain.review.dto.ReviewResponseDto;
import com.movieglass.backend.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies/{movieId}/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewResponseDto>> getReviews(@PathVariable Long movieId) {
        List<ReviewResponseDto> reviews = reviewService.getReviewsByMovieId(movieId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDto> createReview(@PathVariable Long movieId,
                                                          @RequestBody ReviewRequestDto reviewRequestDto) {
        ReviewResponseDto createdReview = reviewService.createReview(movieId, reviewRequestDto);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long movieId,
                                                          @PathVariable Long reviewId,
                                                          @RequestBody ReviewRequestDto reviewRequestDto) {
        ReviewResponseDto updatedReview = reviewService.updateReview(movieId, reviewId, reviewRequestDto);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long movieId,
                                             @PathVariable Long reviewId) {
        reviewService.deleteReview(movieId, reviewId);
        return ResponseEntity.noContent().build();
    }
}

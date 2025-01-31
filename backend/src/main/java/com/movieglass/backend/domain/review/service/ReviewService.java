//package com.movieglass.backend.domain.review.service;
//
//import com.movieglass.backend.domain.movie.entity.Movie;
//import com.movieglass.backend.domain.movie.repository.MovieRepository;
//import com.movieglass.backend.domain.review.converter.ReviewConverter;
//import com.movieglass.backend.domain.review.dto.ReviewRequestDto;
//import com.movieglass.backend.domain.review.dto.ReviewResponseDto;
//import com.movieglass.backend.domain.review.entity.Review;
//import com.movieglass.backend.domain.review.repository.ReviewRepository;
//import com.movieglass.backend.domain.user.entity.User;
//import com.movieglass.backend.domain.user.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class ReviewService {
//
//    private final ReviewRepository reviewRepository;
//    private final MovieRepository movieRepository;
//    private final UserRepository userRepository;
//    private final ReviewConverter reviewConverter;
//
//    public List<ReviewResponseDto> getReviewsByMovieId(Long movieId) {
//        return reviewRepository.findByMovieId(movieId).stream()
//                .map(reviewConverter::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public ReviewResponseDto createReview(Long movieId, ReviewRequestDto reviewRequestDto) {
//        Movie movie = movieRepository.findById(movieId)
//                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));
//        User user = userRepository.findById(reviewRequestDto.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//        Review review = reviewConverter.toEntity(reviewRequestDto, movie, user);
//        review = reviewRepository.save(review);
//        return reviewConverter.toDto(review);
//    }
//
//    public ReviewResponseDto updateReview(Long movieId, Long reviewId, ReviewRequestDto reviewRequestDto) {
//        Review review = reviewRepository.findByIdAndMovieId(reviewId, movieId)
//                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
//        review.update(reviewRequestDto.getRating(), reviewRequestDto.getComment());
//        review = reviewRepository.save(review);
//        return reviewConverter.toDto(review);
//    }
//
//    public void deleteReview(Long movieId, Long reviewId) {
//        Review review = reviewRepository.findByIdAndMovieId(reviewId, movieId)
//                .orElseThrow(() -> new IllegalArgumentException("Review not found"));
//        reviewRepository.delete(review);
//    }
//}

package com.movieglass.backend.domain.review.service;

import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.movie.repository.MovieRepository;
import com.movieglass.backend.domain.review.converter.ReviewConverter;
import com.movieglass.backend.domain.review.dto.ReviewRequestDto;
import com.movieglass.backend.domain.review.dto.ReviewResponseDto;
import com.movieglass.backend.domain.review.entity.Review;
import com.movieglass.backend.domain.review.repository.ReviewRepository;
import com.movieglass.backend.domain.user.entity.User;
import com.movieglass.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ReviewConverter reviewConverter;

    // 영화 ID로 리뷰 목록 조회
    public List<ReviewResponseDto> getReviewsByMovieId(Long movieId) {
        return reviewRepository.findByMovieId(movieId).stream()
                .map(reviewConverter::toDto)
                .collect(Collectors.toList());
    }

    // 리뷰 생성
    public ReviewResponseDto createReview(Long movieId, ReviewRequestDto reviewRequestDto) {
        // 영화 확인
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found"));

        // 사용자 확인
        User user = userRepository.findById(reviewRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + reviewRequestDto.getUserId()));

        // 리뷰 생성 및 저장
        Review review = reviewConverter.toEntity(reviewRequestDto, movie, user);
        review = reviewRepository.save(review);

        // 생성된 리뷰를 DTO로 반환
        return reviewConverter.toDto(review);
    }

    // 리뷰 수정
    public ReviewResponseDto updateReview(Long movieId, Long reviewId, ReviewRequestDto reviewRequestDto) {
        // 리뷰 확인
        Review review = reviewRepository.findByIdAndMovieId(reviewId, movieId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

        // 리뷰 내용 업데이트
        review.update(reviewRequestDto.getRating(), reviewRequestDto.getComment());

        // 업데이트된 리뷰 저장
        review = reviewRepository.save(review);

        // 수정된 리뷰를 DTO로 반환
        return reviewConverter.toDto(review);
    }

    // 리뷰 삭제
    public void deleteReview(Long movieId, Long reviewId) {
        // 리뷰 확인
        Review review = reviewRepository.findByIdAndMovieId(reviewId, movieId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

        // 리뷰 삭제
        reviewRepository.delete(review);
    }
}


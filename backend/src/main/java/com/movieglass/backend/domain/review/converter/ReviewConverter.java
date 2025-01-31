package com.movieglass.backend.domain.review.converter;

import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.review.dto.ReviewRequestDto;
import com.movieglass.backend.domain.review.dto.ReviewResponseDto;
import com.movieglass.backend.domain.review.entity.Review;
import com.movieglass.backend.domain.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter {

    public Review toEntity(ReviewRequestDto dto, Movie movie, User user) {
        return new Review(movie, user, dto.getRating(), dto.getComment());
    }

    public ReviewResponseDto toDto(Review review) {
        return new ReviewResponseDto(
                review.getId(),
                Long.parseLong(review.getUser().getId()),
                review.getRating(),
                review.getComment(),
                review.getViewCount()
        );
    }
}

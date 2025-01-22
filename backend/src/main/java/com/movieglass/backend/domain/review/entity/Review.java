package com.movieglass.backend.domain.review.entity;

import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Review")
public class Review {

    @Id
    @Column(name = "review_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "KMDb_id", nullable = false)
    private Movie movie;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "review_comment")
    private String comment;

    @Column(name = "view_count")
    private int viewCount;
}

package com.movieglass.backend.domain.review.entity;

import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.user.entity.User;
import com.movieglass.backend.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Review")
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
    @Column(name = "review_id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "review_comment")
    private String comment;

    @Column(name = "view_count")
    private int viewCount;

    // 생성자
    public Review(Movie movie, User user, BigDecimal rating, String comment) {
        this.movie = movie;
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        this.viewCount = 0; // 기본 값
    }

    // 업데이트 메서드
    public void update(BigDecimal rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

}

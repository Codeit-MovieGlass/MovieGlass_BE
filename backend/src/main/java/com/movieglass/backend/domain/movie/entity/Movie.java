package com.movieglass.backend.domain.movie.entity;

import com.movieglass.backend.domain.review.entity.Review;
import com.movieglass.backend.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 설정
    private Long Id;

    @Column(name = "KMDb_id")
    private String kmdbId;

    @Column(name = "TMDb_id")
    private String tmdbId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "production_type")
    private String productionType;

    @Column(name = "production_length")
    private String productionLength;

    @Column(name = "production_genre")
    private String productionGenre;

    @Column(name = "production_country")
    private String productionCountry;

    @Column(name = "production_time")
    private Integer productionTime;

    @Column(name = "production_keyword")
    private String productionKeyword;

    @Column(name = "production_plot")
    @Lob
    private String productionPlot;

    @Column(name = "production_image")
    private String productionImage;

    @Column(name = "horizontal_image", length = 255)
    private String horizontalImage;

    @Setter
    @Column(name = "trailer_url")
    private String trailerUrl;
    @OneToMany(mappedBy = "movie")
    private Collection<Review> review;

    public Collection<Review> getReview() {
        return review;
    }

    public void setReview(Collection<Review> review) {
        this.review = review;
    }
}

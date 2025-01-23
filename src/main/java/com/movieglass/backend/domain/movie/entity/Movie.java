package com.movieglass.backend.domain.movie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "KMDb_id", nullable = false)
    private String id;

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
    private String productionPlot;

    @Column(name = "production_image")
    private String productionImage;

    @Column(name = "horizontal_image", length = 255)
    private String horizontalImage;
}

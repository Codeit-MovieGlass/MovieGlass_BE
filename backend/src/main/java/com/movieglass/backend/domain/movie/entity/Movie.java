package com.movieglass.backend.domain.movie.entity;

import com.movieglass.backend.domain.review.entity.Review;
import com.movieglass.backend.domain.collection.entity.CollectionMovie;
import com.movieglass.backend.domain.curation.entity.CurationMovie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class Movie {

    @Id
    @Column(name = "KMDb_id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "actors")
    private String actors;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionMovie> collectionMovies;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurationMovie> curationMovies;
}

package com.movieglass.backend.domain.collection.entity;

import com.movieglass.backend.domain.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "CollectionMovie")
public class CollectionMovie {

    @Id
    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false)
    private Collection collection;

    @Id
    @ManyToOne
    @JoinColumn(name = "KMDb_id", nullable = false)
    private Movie movie;
}

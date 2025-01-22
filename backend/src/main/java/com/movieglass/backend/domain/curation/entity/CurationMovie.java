package com.movieglass.backend.domain.curation.entity;

import com.movieglass.backend.domain.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "CurationMovie")
public class CurationMovie {

    @Id
    @ManyToOne
    @JoinColumn(name = "curation_id", nullable = false)
    private Curation curation;

    @Id
    @ManyToOne
    @JoinColumn(name = "KMDb_id", nullable = false)
    private Movie movie;
}

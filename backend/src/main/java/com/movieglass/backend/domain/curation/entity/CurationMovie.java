package com.movieglass.backend.domain.curation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "CurationMovie")
public class CurationMovie extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "curation_id", nullable = false)
    @JsonBackReference
    private Curation curation;

    @Id
    @ManyToOne
    @JoinColumn(name = "KMDb_id", nullable = false)
    private Movie movie;
}

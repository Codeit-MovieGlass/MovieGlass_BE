package com.movieglass.backend.domain.curation.entity;

import com.movieglass.backend.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Curation")
public class Curation extends BaseEntity {

    @Id
    @Column(name = "curation_id")
    private String id;

    @Column(name = "curation_name")
    private String name;

    @Column(name = "curation_description")
    private String description;

    @OneToMany(mappedBy = "curation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CurationMovie> curationMovies;
}

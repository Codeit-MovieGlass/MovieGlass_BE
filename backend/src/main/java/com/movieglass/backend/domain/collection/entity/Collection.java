package com.movieglass.backend.domain.collection.entity;

import com.movieglass.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Collection")
public class Collection {

    @Id
    @Column(name = "collection_id")
    private String id;

    @Column(name = "collection_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CollectionMovie> collectionMovies;
}

package com.movieglass.backend.domain.recommendation.entity;

import com.movieglass.backend.domain.user.entity.User;
import com.movieglass.backend.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Recommendation")
public class Recommendation extends BaseEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "genre")
    private String genre;

    @Column(name = "weight")
    private int weight;
}

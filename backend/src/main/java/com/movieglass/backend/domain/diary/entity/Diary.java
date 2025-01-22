package com.movieglass.backend.domain.diary.entity;

import com.movieglass.backend.domain.movie.entity.Movie;
import com.movieglass.backend.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Diary")
public class Diary {

    @Id
    @Column(name = "diary_id")
    private String id;

    @Column(name = "diary_name")
    private String name;

    @Column(name = "diary_comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "KMDb_id", nullable = false)
    private Movie movie;
}

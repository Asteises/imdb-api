package ru.asteises.imdbapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    private UUID movieId;

    private int rank;

    private String title;

    private String thumbnail;

    private String rating;

    private String id;

    private int year;

    private String image;

    private String description;

    private String trailer;

    @ManyToMany
    @JoinTable(name = "Movie_genre",
            joinColumns = @JoinColumn(name = "Movie_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genre;

    @ManyToMany
    @JoinTable(name = "Movie_director",
            joinColumns = @JoinColumn(name = "Movie_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id"))
    private Set<Director> director;

    @ManyToMany
    @JoinTable(name = "Movie_writers",
            joinColumns = @JoinColumn(name = "Movie_movie_id"),
            inverseJoinColumns = @JoinColumn(name = "writers_id"))
    private Set<Writer> writers;

    private String imdbid;
}

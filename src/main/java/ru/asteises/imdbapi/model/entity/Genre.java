package ru.asteises.imdbapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Genre")
public class Genre {

    @Id
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "genre")
    private Set<Movie> movies;
}

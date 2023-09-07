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
@Entity(name = "Director")
public class Director {

    @Id
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "director")
    private Set<Movie> movies;
}

package ru.asteises.imdbapi.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.imdbapi.model.entity.Genre;

import java.util.UUID;

@Repository
public interface GenreRepo extends JpaRepository<Genre, UUID> {
}

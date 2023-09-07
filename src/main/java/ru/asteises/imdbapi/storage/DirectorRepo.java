package ru.asteises.imdbapi.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asteises.imdbapi.model.entity.Director;

import java.util.UUID;

public interface DirectorRepo extends JpaRepository<Director, UUID> {
}

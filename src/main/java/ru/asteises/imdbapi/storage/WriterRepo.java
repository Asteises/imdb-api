package ru.asteises.imdbapi.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.asteises.imdbapi.model.entity.Writer;

import java.util.UUID;

@Repository
public interface WriterRepo extends JpaRepository<Writer, UUID> {
}

package ru.asteises.imdbapi.service;

import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.model.dto.GenreViewDto;
import ru.asteises.imdbapi.model.entity.Genre;

import java.util.List;

@Service
public interface GenreService {

    List<GenreViewDto> saveAll(List<Genre> genres);
}

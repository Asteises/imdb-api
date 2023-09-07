package ru.asteises.imdbapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.mapper.GenreMapper;
import ru.asteises.imdbapi.model.dto.GenreViewDto;
import ru.asteises.imdbapi.model.entity.Genre;
import ru.asteises.imdbapi.storage.GenreRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepo genreRepo;

    @Override
    public List<GenreViewDto> saveAll(List<Genre> genres) {
        genreRepo.saveAll(genres);
        return GenreMapper.INSTANCE.toViewDto(genres);
    }
}

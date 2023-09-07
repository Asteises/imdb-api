package ru.asteises.imdbapi.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.imdbapi.model.dto.GenreViewDto;
import ru.asteises.imdbapi.model.entity.Genre;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class})
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    default Set<Genre> toEntity(String[] genre) {
        Set<Genre> genres = new HashSet<>();
        if (genre == null) {
            return genres;
        }
        for (String genreName : genre) {
            genres.add(new Genre(UUID.randomUUID(), genreName, new HashSet<>()));
        }
        return genres;
    }

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "name", source = "genre")
    @Mapping(target = "movies", ignore = true)
    Genre toEntity(String genre);

    GenreViewDto toViewDto(Genre genre);

    List<GenreViewDto> toViewDto(List<Genre> genres);
}

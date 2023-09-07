package ru.asteises.imdbapi.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.imdbapi.model.dto.MovieApiDto;
import ru.asteises.imdbapi.model.dto.MovieViewDto;
import ru.asteises.imdbapi.model.entity.Movie;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class},
        uses = {GenreMapper.class, DirectorMapper.class, WriterMapper.class})
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "movieId", expression = "java(UUID.randomUUID())")
    @Mapping(target = "genre", expression = "java(GenreMapper.INSTANCE.toEntity(movieApiDto.getGenre()))")
    @Mapping(target = "director", expression = "java(DirectorMapper.INSTANCE.toEntity(movieApiDto.getDirector()))")
    @Mapping(target = "writers", expression = "java(WriterMapper.INSTANCE.toEntity(movieApiDto.getWriters()))")
    Movie toEntity(MovieApiDto movieApiDto);

    List<Movie> toEntity(List<MovieApiDto> movieApiDtos);

    @Mapping(target = "genre", expression = "java(GenreMapper.INSTANCE.toViewDto(movie.getGenre().stream().toList()))")
    @Mapping(target = "director", expression = "java(DirectorMapper.INSTANCE.toViewDto(movie.getDirector().stream().toList()))")
    @Mapping(target = "writers", expression = "java(WriterMapper.INSTANCE.toViewDto(movie.getWriters().stream().toList()))")
    MovieViewDto toViewDto(Movie movie);

    List<MovieViewDto> toViewDto(List<Movie> movies);
}

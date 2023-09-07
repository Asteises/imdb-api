package ru.asteises.imdbapi.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.imdbapi.model.dto.DirectorViewDto;
import ru.asteises.imdbapi.model.entity.Director;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class})
public interface DirectorMapper {

    DirectorMapper INSTANCE = Mappers.getMapper(DirectorMapper.class);

    default Set<Director> toEntity(String[] director) {
        Set<Director> directors = new HashSet<>();
        if (director == null) {
            return directors;
        }
        for (String directorName : director) {
            directors.add(new Director(UUID.randomUUID(), directorName, new HashSet<>()));
        }
        return directors;
    }

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "name", source = "director")
    @Mapping(target = "movies", ignore = true)
    Director toEntity(String director);

    DirectorViewDto toViewDto(Director director);

    List<DirectorViewDto> toViewDto(List<Director> directors);
}
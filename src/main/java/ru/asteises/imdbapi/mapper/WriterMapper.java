package ru.asteises.imdbapi.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.asteises.imdbapi.model.dto.WriterViewDto;
import ru.asteises.imdbapi.model.entity.Writer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {UUID.class})
public interface WriterMapper {

    WriterMapper INSTANCE = Mappers.getMapper(WriterMapper.class);

    default Set<Writer> toEntity(String[] writers) {
        Set<Writer> writerSet = new HashSet<>();
        if (writers == null) {
            return writerSet;
        }
        for (String writerName : writers) {
            writerSet.add(new Writer(UUID.randomUUID(), writerName, new HashSet<>()));
        }
        return writerSet;
    }

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "name", source = "writer")
    @Mapping(target = "movies", ignore = true)
    Writer toEntity(String writer);

    WriterViewDto toViewDto(Writer writer);

    List<WriterViewDto> toViewDto(List<Writer> writers);
}
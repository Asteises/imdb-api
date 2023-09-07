package ru.asteises.imdbapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.mapper.DirectorMapper;
import ru.asteises.imdbapi.model.dto.DirectorViewDto;
import ru.asteises.imdbapi.model.entity.Director;
import ru.asteises.imdbapi.storage.DirectorRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepo directorRepo;

    @Override
    public List<DirectorViewDto> saveAll(List<Director> directors) {
        directorRepo.saveAll(directors);
        return DirectorMapper.INSTANCE.toViewDto(directors);
    }
}

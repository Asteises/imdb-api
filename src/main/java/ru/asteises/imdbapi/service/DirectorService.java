package ru.asteises.imdbapi.service;

import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.model.dto.DirectorViewDto;
import ru.asteises.imdbapi.model.entity.Director;

import java.util.List;

@Service
public interface DirectorService {

    List<DirectorViewDto> saveAll(List<Director> directors);
}

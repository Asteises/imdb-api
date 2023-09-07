package ru.asteises.imdbapi.service;

import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.model.dto.WriterViewDto;
import ru.asteises.imdbapi.model.entity.Writer;

import java.util.List;

@Service
public interface WriterService {

    List<WriterViewDto> saveAll(List<Writer> writers);
}

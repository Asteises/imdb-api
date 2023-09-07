package ru.asteises.imdbapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.mapper.WriterMapper;
import ru.asteises.imdbapi.model.dto.WriterViewDto;
import ru.asteises.imdbapi.model.entity.Writer;
import ru.asteises.imdbapi.storage.WriterRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class WriterServiceImpl implements WriterService {

    private final WriterRepo writerRepo;

    @Override
    public List<WriterViewDto> saveAll(List<Writer> writers) {
        writerRepo.saveAll(writers);
        return WriterMapper.INSTANCE.toViewDto(writers);
    }
}

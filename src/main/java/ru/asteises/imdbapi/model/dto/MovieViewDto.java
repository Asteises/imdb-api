package ru.asteises.imdbapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieViewDto {

    private int rank;
    private String title;
    private String thumbnail;
    private String rating;
    private int year;
    private String image;
    private String description;
    private String trailer;
    private List<GenreViewDto> genre;
    private List<DirectorViewDto> director;
    private List<WriterViewDto> writers;
}

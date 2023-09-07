package ru.asteises.imdbapi.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.model.dto.MovieViewDto;
import ru.asteises.imdbapi.model.entity.Movie;

import java.util.List;

@Service
public interface MovieService {

    List<MovieViewDto> getTop100Movies(OkHttpClient client, Request request);

    MovieViewDto getMovieFromTop100ById(OkHttpClient client, Request request);

    Movie getMovieFromMainSource(OkHttpClient client, Request request);

    MovieViewDto saveFullMovieData(Movie movie);

    void saveMovie(Movie movie);
}

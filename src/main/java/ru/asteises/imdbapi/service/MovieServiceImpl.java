package ru.asteises.imdbapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import ru.asteises.imdbapi.mapper.MovieMapper;
import ru.asteises.imdbapi.model.dto.MovieApiDto;
import ru.asteises.imdbapi.model.dto.MovieViewDto;
import ru.asteises.imdbapi.model.entity.Movie;
import ru.asteises.imdbapi.storage.MovieRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;
    private final GenreService genreService;
    private final DirectorService directorService;
    private final WriterService writerService;

    /**
     * Получить Топ 100 фильмов.
     * @param client - OkHttpClient
     * @param request - Request
     * @return - List<MovieViewDto>
     */
    @Override
    public List<MovieViewDto> getTop100Movies(OkHttpClient client, Request request) {
        List<MovieApiDto> top100MovieApiDtos = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = getResponseBody(client, request);
        try {
            // TODO как принять лист?
            top100MovieApiDtos = Arrays.stream(objectMapper.readValue(
                    responseBody.bytes(), MovieApiDto[].class)).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Movie> movies = getMoviesFromMainSource(top100MovieApiDtos);
        return MovieMapper.INSTANCE.toViewDto(movies);
    }

    /**
     * Получить Топ 100 фильмов из стороннего api.
     * @param movieApiDtos - List<MovieApiDto>
     * @return - List<Movie>
     */
    public List<Movie> getMoviesFromMainSource(List<MovieApiDto> movieApiDtos) {
        return MovieMapper.INSTANCE.toEntity(movieApiDtos);
    }

    /**
     * Получить фильм из Топ 100.
     * @param client - OkHttpClient
     * @param request - Request
     * @return - MovieViewDto
     */
    @Override
    public MovieViewDto getMovieFromTop100ById(OkHttpClient client, Request request) {
        Movie movie = getMovieFromMainSource(client, request);
        return saveFullMovieData(movie);
    }

    /**
     * Получить фильм из стороннего api.
     * @param client - OkHttpClient
     * @param request - Request
     * @return - Movie
     */
    @Override
    public Movie getMovieFromMainSource(OkHttpClient client, Request request) {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseBody responseBody = getResponseBody(client, request);
        MovieApiDto movieApiDto = new MovieApiDto();
        try {
            movieApiDto = objectMapper.readValue(responseBody.bytes(), MovieApiDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MovieMapper.INSTANCE.toEntity(movieApiDto);
    }

    /**
     * Получить тело ответа.
     * @param client - OkHttpClient
     * @param request - Request
     * @return - ResponseBody
     */
    private ResponseBody getResponseBody(OkHttpClient client, Request request) {
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    return responseBody;
                } else {
                    throw new RuntimeException("ResponseBody is null");
                }
            } else {
                throw new RuntimeException("Response is bad request");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Something wrong");
    }

    /**
     * Сохраняем все дополнительные данные фильма:
     * жанры, режиссеры, сценаристы.
     * @param movie - Movie
     * @return - MovieViewDto
     */
    @Override
    public MovieViewDto saveFullMovieData(Movie movie) {
        genreService.saveAll(movie.getGenre().stream().toList());
        directorService.saveAll(movie.getDirector().stream().toList());
        writerService.saveAll(movie.getWriters().stream().toList());
        saveMovie(movie);
        return MovieMapper.INSTANCE.toViewDto(movie);
    }

    /**
     * Сохранение фильма в базу данных
     * @param movie - Movie
     */
    @Override
    public void saveMovie(Movie movie) {
        movieRepo.save(movie);
        log.info("Movie saved");
    }
}
package ru.asteises.imdbapi.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asteises.imdbapi.model.dto.MovieViewDto;
import ru.asteises.imdbapi.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api")
@Getter
@Setter
@AllArgsConstructor
public class ClientApiController {

    // TODO Обернуть в докер
    // TODO CICD - Editor - выбрать ветку на 8086 порту
    private final OkHttpClient client;
    private final MovieService movieService;

    /**
     * Получить Топ 100 фильмов без сохранения в базу данных.
     * @return - List<MovieViewDto>
     */
    @GetMapping("/top100movies")
    public ResponseEntity<List<MovieViewDto>> getTop100Movies() {
        return ResponseEntity.ok(movieService.getTop100Movies(getClient(), getRequest("")));
    }

    /**
     * Получить фильм по id в формате api: top17. Фильм будет сохранен в базу данных с
     * присвоением внутреннего id.
     * @param movieId - id в формате: top17
     * @return - MovieViewDto
     */
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieViewDto> getMovieFromTop100ById(@PathVariable String movieId) {
        return ResponseEntity.ok(movieService.getMovieFromTop100ById(getClient(), getRequest(movieId)));
    }

    /**
     * Настройки для подключения к стороннему api
     * @param partOfUrl - дополнение к url
     * @return - Request
     */
    private Request getRequest(String partOfUrl) {
        return new Request.Builder()
                .url(getUrlForRequest(partOfUrl))
                .get()
                .addHeader("X-RapidAPI-Key", "fa78f182f5msh4d8dff35ccd9cb3p161fabjsn974df09fe8f5")
                .addHeader("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
                .build();
    }

    private String getUrlForRequest(String partOfUrl) {
        return "https://imdb-top-100-movies.p.rapidapi.com/" + partOfUrl;
    }

    /**
     * Основной клиент в формате singleton
     * @return - OkHttpClient
     */
    private OkHttpClient getClient() {
        return this.client;
    }
}


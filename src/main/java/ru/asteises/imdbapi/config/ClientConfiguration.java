package ru.asteises.imdbapi.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient();
    }
}

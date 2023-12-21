package com.java.prueba.richar.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.java.prueba.richar.application.services.FilmService;
import com.java.prueba.richar.application.usecases.*;
import com.java.prueba.richar.domain.ports.out.ExternalServicePort;
import com.java.prueba.richar.domain.ports.out.FilmRepositoryPort;
import com.java.prueba.richar.infrastructure.adapters.ExternalServiceAdapter;
import com.java.prueba.richar.infrastructure.repositories.JpaFilmRepositoryAdapter;

@Configuration
public class ApplicationConfig {

    // inject dependencies here, because it's decoupled from framework
    @Bean
    FilmService filmService(
            FilmRepositoryPort filmRepositoryPort,
            ExternalServicePort externalServicePort
    ) {
        return new FilmService(
                new FilmUseCaseImpl(filmRepositoryPort,externalServicePort)
        );
    }

    @Bean
    FilmRepositoryPort filmRepositoryPort(JpaFilmRepositoryAdapter jpaFilmRepositoryAdapter) {
		return jpaFilmRepositoryAdapter;
	}

    @Bean
    ExternalServicePort externalServicePort() {
		return new ExternalServiceAdapter(new RestTemplate());
	}
}

package com.java.prueba.richar.infrastructure.adapters;

import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.java.prueba.richar.domain.model.Film;
import com.java.prueba.richar.domain.ports.out.ExternalServicePort;

public class ExternalServiceAdapter implements ExternalServicePort {

	private final RestTemplate restTemplate;

	public ExternalServiceAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Optional<Film> getFilmById(Long id) {
		try {
		String apiUrl = "https://swapi.dev/api/films/" + id;
		ResponseEntity<FilmApi> filmResponse = this.restTemplate.getForEntity(apiUrl, FilmApi.class);

		FilmApi film = filmResponse.getBody();

		if (film == null || filmResponse.getStatusCode() != HttpStatusCode.valueOf(200)) {
			return Optional.empty();
		}
		return Optional.ofNullable(new Film(id, film.getEpisode_id(), film.getTitle(), film.getRelease_date()));
		}
		catch(RestClientException e) {
			return Optional.empty();
		}
	}

	private static class FilmApi {
		private Long episode_id;
		private String title;
		private String release_date;

		public Long getEpisode_id() {
			return episode_id;
		}

		public String getTitle() {
			return title;
		}

		public String getRelease_date() {
			return release_date;
		}
	}
}

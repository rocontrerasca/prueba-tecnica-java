package com.java.prueba.richar.application.services;

import java.util.List;
import java.util.Optional;

import com.java.prueba.richar.domain.model.Film;
import com.java.prueba.richar.domain.ports.in.*;

public class FilmService implements FilmUseCase {

	private final FilmUseCase filmUseCase;

	public FilmService(
			FilmUseCase filmUseCase
    ) {
        this.filmUseCase = filmUseCase;
    }

	@Override
	public Optional<Film> getFilm(Long id) {
		return this.filmUseCase.getFilm(id);
	}

	@Override
	public Optional<Film> updateFilm(Film film) {
		return this.filmUseCase.updateFilm(film);
	}
	
	@Override
	public boolean deleteFilm(long id) {
		return this.filmUseCase.deleteFilm(id);
	}
	
	@Override
	public List<Film> getAllFilms() {
		return this.filmUseCase.getAllFilms();
	}
}

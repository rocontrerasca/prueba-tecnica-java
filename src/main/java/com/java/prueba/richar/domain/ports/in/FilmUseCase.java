package com.java.prueba.richar.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.java.prueba.richar.domain.model.Film;

public interface FilmUseCase {
    Optional<Film> getFilm(Long id);
    Optional<Film> updateFilm(Film film);
	boolean deleteFilm(long id);
	List<Film> getAllFilms();
}

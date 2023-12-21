package com.java.prueba.richar.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.java.prueba.richar.domain.model.Film;

public interface FilmRepositoryPort {
	Film save(Film film);
	Optional<Film> update(Film film);
	boolean delete(long id);
	List<Film> getAllFilms();
}

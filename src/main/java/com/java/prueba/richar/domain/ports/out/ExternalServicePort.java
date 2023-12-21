package com.java.prueba.richar.domain.ports.out;

import java.util.Optional;

import com.java.prueba.richar.domain.model.Film;

public interface ExternalServicePort {
	Optional<Film> getFilmById(Long id);
}

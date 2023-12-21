package com.java.prueba.richar.application.usecases;

import java.util.List;
import java.util.Optional;

import com.java.prueba.richar.domain.model.Film;
import com.java.prueba.richar.domain.ports.in.FilmUseCase;
import com.java.prueba.richar.domain.ports.out.ExternalServicePort;
import com.java.prueba.richar.domain.ports.out.FilmRepositoryPort;

public class FilmUseCaseImpl implements FilmUseCase {
    private final FilmRepositoryPort filmRepositoryPort;
    private final ExternalServicePort externalServicePort;
    
    public FilmUseCaseImpl(FilmRepositoryPort filmRepositoryPort, 
    		ExternalServicePort externalServicePort) {
        this.filmRepositoryPort = filmRepositoryPort;
        this.externalServicePort = externalServicePort;
    }

    @Override
    public Optional<Film> getFilm(Long id) {
    	Optional<Film> response = this.externalServicePort.getFilmById(id);
    	if(!response.isEmpty()) {
    		this.filmRepositoryPort.save(response.get());
    	}
        return response;
    }

	@Override
	public Optional<Film> updateFilm(Film film) {
		return this.filmRepositoryPort.update(film);
	}

	@Override
	public boolean deleteFilm(long id) {
		return this.filmRepositoryPort.delete(id);
	}

	@Override
	public List<Film> getAllFilms() {
		return this.filmRepositoryPort.getAllFilms();
	}
}

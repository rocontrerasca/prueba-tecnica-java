package com.java.prueba.richar.infrastructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.java.prueba.richar.domain.model.Film;
import com.java.prueba.richar.domain.ports.out.FilmRepositoryPort;
import com.java.prueba.richar.infrastructure.entities.FilmEntity;

@Component
public class JpaFilmRepositoryAdapter implements FilmRepositoryPort {

    private final JpaFilmRepository jpaFilmRepository;

    public JpaFilmRepositoryAdapter(JpaFilmRepository jpaFilmRepository) {
        this.jpaFilmRepository = jpaFilmRepository;
    }

    private boolean existsByEpisodeId(Long id) {
        return this.jpaFilmRepository.existsByEpisodeId(id);
    }
    
    private boolean existsById(Long id) {
        return this.jpaFilmRepository.existsById(id);
    }

	@Override
	public Film save(Film film) {
		if(existsByEpisodeId(film.getEpisodeId()))
			return film;
		FilmEntity filmEntity = FilmEntity.fromDomainModel(film);
        FilmEntity savedTaskEntity = jpaFilmRepository.save(filmEntity);
        return savedTaskEntity.toDomainModel();
	}

	@Override
	public Optional<Film> update(Film film) {
		if(!existsById(film.getId()))
			return Optional.empty();
		FilmEntity filmEntity = FilmEntity.fromDomainModel(film);
        FilmEntity savedTaskEntity = jpaFilmRepository.save(filmEntity);
        return Optional.of(savedTaskEntity.toDomainModel());
	}

	@Override
	public boolean delete(long id) {
		if(!existsById(id))
			return false;
		jpaFilmRepository.deleteById(id);
		return true;
	}

	@Override
	public List<Film> getAllFilms() {
		 return this.jpaFilmRepository.findAll()
	                .stream()
	                .map(FilmEntity::toDomainModel)
	                .toList();
	}
}

package com.java.prueba.richar.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.prueba.richar.infrastructure.entities.FilmEntity;

@Repository
public interface JpaFilmRepository extends JpaRepository<FilmEntity, Long> {
	public boolean existsByEpisodeId(Long id);
}

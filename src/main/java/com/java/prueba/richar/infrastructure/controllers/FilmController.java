package com.java.prueba.richar.infrastructure.controllers;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.prueba.richar.application.services.FilmService;
import com.java.prueba.richar.domain.model.Film;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/films")
public class FilmController {

	private final FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@GetMapping("/{id}")
	public ResponseEntity getFilmById(@PathVariable String id) {
		if (!id.matches("[0-9]+")) {
			return new ResponseEntity<>("Error en la solicitud", HttpStatus.BAD_REQUEST);
		}
		return this.filmService.getFilm(Long.parseLong(id)).map(ResponseEntity::ok)
				.orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping()
	public ResponseEntity getFilms() {
		List<Film> tasks = this.filmService.getAllFilms();
        return ResponseEntity.ok(tasks);
	}

	@PutMapping()
	public ResponseEntity updateFilm(@Valid @RequestBody Film film) {
		if (film == null) {
			return new ResponseEntity<>("Error en la solicitud", HttpStatus.BAD_REQUEST);
		}
		return this.filmService.updateFilm(film).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteTask(@PathVariable String id) {

		if (!id.matches("[0-9]+")) {
			return new ResponseEntity<>("Error en la solicitud", HttpStatus.BAD_REQUEST);
		}
		boolean isDeleted = this.filmService.deleteFilm(Long.parseLong(id));

		return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
	}
}

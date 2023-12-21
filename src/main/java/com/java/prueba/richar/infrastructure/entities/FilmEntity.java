package com.java.prueba.richar.infrastructure.entities;

import com.java.prueba.richar.domain.model.Film;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class FilmEntity {

    @Id
    @Column(name = "film_id")
    private Long id;
    private Long episodeId;
    private String title;
    private String releaseDate;
    
    public FilmEntity() {
    }

	public FilmEntity(Long id, Long episodeId, String title, String releaseDate) {
		super();
		this.id = id;
		this.episodeId = episodeId;
		this.title = title;
		this.releaseDate = releaseDate;
	}
	
	 public static FilmEntity fromDomainModel(Film film) {
	        return new FilmEntity(
	        		film.getId(),
	        		film.getEpisodeId(),
	        		film.getTitle(),
	        		film.getReleaseDate()
	        );
	    }

	    public Film toDomainModel() {
	        return new Film(
	                id,
	                episodeId,
	                title,
	                releaseDate
	        );
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Long episodeId) {
		this.episodeId = episodeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}

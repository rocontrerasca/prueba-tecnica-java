package com.java.prueba.richar.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Film {
	
	@NotNull(message = "The field is required.")
    private Long id;
	@NotNull(message = "The field is required.")
    private Long episodeId;
	@NotNull(message = "The field is required.")
	@NotBlank(message = "The field is required.")
    private String title;
	@NotNull(message = "The field is required.")
	@NotBlank(message = "The field is required.")
    private String releaseDate;
    
    public Film() {
    }

    public Film(Long id, Long episodeId, String title, String releaseDate) {
		super();
		this.id = id;
		this.episodeId = episodeId;
		this.title = title;
		this.releaseDate = releaseDate;
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

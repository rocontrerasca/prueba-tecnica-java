package com.java.prueba.richar;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.MOCK,
  classes = PruebaRicharApplication.class)
@AutoConfigureMockMvc
class PruebaRicharApplicationTests {
	@Autowired
    private MockMvc mvc;

	@Test
	void givenFilms_thenStatus200() throws Exception {
	    mvc.perform(get("https://localhost:8080/films/1")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	    
	    mvc.perform(get("https://localhost:8080/films/2")
	  	      .contentType(MediaType.APPLICATION_JSON))
	  	      .andExpect(status().isOk());
	}
	
	@Test
	void givenFilms_thenStatus204() throws Exception {
	    mvc.perform(get("https://localhost:8080/films/10")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isNoContent());
	}
	
	@Test
	void givenFilms_thenStatus400() throws Exception {
	    mvc.perform(get("https://localhost:8080/films/10aAb")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isBadRequest())
	      .andExpect(content().string(containsString("Error en la solicitud")));
	}
	
	@Test
	void updateFilms_thenStatus200() throws Exception {
		String requestbody = "{\"id\": 1,\"episodeId\": 4,\"title\": \"A New Hope 5\",\"releaseDate\": \"1977-05-25\"}";
	    mvc.perform(put("https://localhost:8080/films")
	    		.content(requestbody)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
	
	@Test
	void updateFilms_thenStatus404() throws Exception {
		String requestbody = "{\"id\": 101,\"episodeId\": 4,\"title\": \"A New Hope 2\",\"releaseDate\": \"1977-05-25\"}";
	    mvc.perform(put("https://localhost:8080/films")
	    		.content(requestbody)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isNotFound());
	}
	
	@Test
	void deleteFilms_thenStatus200() throws Exception {
	    mvc.perform(delete("https://localhost:8080/films/2")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
	
	@Test
	void deleteFilms_thenStatus400() throws Exception {
	    mvc.perform(delete("https://localhost:8080/films/18sb")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isBadRequest())
	      .andExpect(content().string(containsString("Error en la solicitud")));
	}
	
	@Test
	void deleteFilms_thenStatus404() throws Exception {
	    mvc.perform(delete("https://localhost:8080/films/98")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isNotFound());
	}
	
	@Test
	void getAllFilms_thenStatus200() throws Exception {
	    mvc.perform(get("https://localhost:8080/films")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}
}

package com.cg.test;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.entity.Hero;
import com.cg.exception.HeroNotFoundException;
import com.cg.rest.HeroRestController;
import com.cg.service.IHeroService;

@RunWith(SpringRunner.class)
@WebMvcTest(HeroRestController.class)
public class TestHeroController {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IHeroService service;
	
	@Test
	public void testGetHero() throws Exception {
		Hero hero = new Hero(12, "Hulk", "Mutation", "Smashing", null);
		Mockito.when(service.get(12)).thenReturn(hero);
		
		RequestBuilder builder = MockMvcRequestBuilders.get("/get?id=12")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(builder)
				.andExpect(status().isOk())
				.andExpect(jsonPath("name", is(hero.getName()))).andReturn();
		
		System.out.println(result.getResponse().getContentAsString());
		
		String expected = "{\"id\":12,\"name\":\"Hulk\",\"power\":\"Mutation\",\"strength\":\"Smashing\",\"uid\":0}";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testGetNonHero() throws Exception {
		Mockito.when(service.get(14)).thenThrow(HeroNotFoundException.class);
		
		RequestBuilder builder = MockMvcRequestBuilders.get("/get?id=14")
				.accept(MediaType.APPLICATION_JSON);
		
		mvc.perform(builder)
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void testServiceGet() throws HeroNotFoundException {
		Mockito.when(service.get(14)).thenThrow(HeroNotFoundException.class);
	}
	
}

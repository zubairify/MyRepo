package com.cg.test;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.entity.Universe;
import com.cg.exception.UniverseNotFoundException;
import com.cg.rest.UniverseRestController;
import com.cg.service.IUniverseService;

@RunWith(SpringRunner.class)
@WebMvcTest(UniverseRestController.class)
public class TestUniverseController {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IUniverseService service;
	
	@Test
	public void testAddUniverse() throws Exception {
		Universe universe = new Universe(3, "Galaxy");
		
		when(service.add(universe)).thenReturn(universe);
		
		RequestBuilder builder = MockMvcRequestBuilders.post("/addu")
				.accept(MediaType.APPLICATION_JSON)
				.content(universe.toString())
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(builder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		System.out.println(result.getResponse().getStatus());
	}
	
	@Test
	public void testGetUniverse() throws Exception {
		
		Universe univ = new Universe(1, "Marvel");
		when(service.get(1)).thenReturn(univ);
		
		
	}
	
	@Test
	public void testGetNonUniverse() throws Exception {
		when(service.get(10)).thenThrow(UniverseNotFoundException.class);
		
		
	}
}

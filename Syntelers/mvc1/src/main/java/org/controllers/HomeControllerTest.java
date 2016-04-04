package org.controllers;

import static java.util.Arrays.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;


public class HomeControllerTest {
	private static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	@Test
	public void shouldDisplayRecentSpittles(){
		List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(), new Spittle());
		
		SpitterService spitterService = mock(SpitterService.class);
		
		when(spitterService.getRecentSpitter(DEFAULT_SPITTLES_PER_PAGE)).thenReturn(expectedSpittles);
		MainController controller = new MainController(spitterService);
		HashMap<String, Object> model = new HashMap<String, Object>();
		String viewName = controller.showHomePage(model);
		assertEquals("home", viewName);
		assertSame(expectedSpittles, model.get("spittles"));
		verify(spitterService).getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE);
	}
}

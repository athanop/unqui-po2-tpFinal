package ar.edu.unq.po2;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ar.edu.unq.po2.Area.Area;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionTemporal;

class DesafioTestCase {

	private Desafio desafio;
	private RestriccionTemporal restriccion;
	private Area area;

	@BeforeEach
	void setUp() throws Exception {
		restriccion = mock(RestriccionTemporal.class);
		area = mock(Area.class);
		desafio = new Desafio(1, 2, 50, restriccion, area);
	}

	@Test
	void testGetMuestrasRecolectadas() {
		assertEquals(desafio.getMuestrasRecolectadas(), 1);
		desafio.setMuestrasRecolectadas(2);
		assertEquals(desafio.getMuestrasRecolectadas(), 2);
	}
	
	@Test
	void testGetDificultad() {
		assertEquals(desafio.getDificultad(), 2);
	}
	
	@Test
	void testGetRecompensa() {
		assertEquals(desafio.getRecompensa(), 50);
	}
	
	@Test
	void testRestriccionTemporal() {
		assertEquals(desafio.getRestriccion(), restriccion);
	}
	
	@Test
	void testArea() {
		assertEquals(desafio.getArea(), area);
	}
}

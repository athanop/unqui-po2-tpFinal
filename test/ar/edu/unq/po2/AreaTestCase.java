package ar.edu.unq.po2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Area.Area;
import ar.edu.unq.po2.Area.Coordenada;

class AreaTestCase {

	Area area;
	Coordenada coordenada1, coordenada2;

	@BeforeEach
	void setUp() throws Exception {
		coordenada1 = mock(Coordenada.class);
		area = new Area(coordenada1, 50d);
	}

	@Test
	void testUnAreaConoceSuEpicentroYSuRadio() {
		assertEquals(area.getRadio(), 50d);
		assertEquals(area.getEpicentro(), coordenada1);
	}

	@Test
	void testCalcularArea() {
		assertEquals(area.calcularArea(), 7854);
	}
	
	@Test
	void testElAreaSabeSiSeEncuentraDentroDeUnasCoordenadas() {
		
		when(coordenada1.getLatitud()).thenReturn(0d);
		when(coordenada1.getLongitud()).thenReturn(0d);
		
		area = new Area(coordenada1, 25d);
		
		assertTrue(area.coordenadaEstaDentroDelArea(coordenada1));
	}

}

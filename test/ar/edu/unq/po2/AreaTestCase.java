package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	
	
}

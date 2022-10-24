package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Area.Coordenada;

class CoordenadaTestCase {

	Coordenada coordenada, coordenada2;;
	
	@BeforeEach
	void setUp() throws Exception {
		coordenada = new Coordenada(20d, 20d);
	}

	@Test
	void testUnaCoordenadaConoceSuLatitudYLongitud20() {
		assertEquals(20d, coordenada.getLatitud());
		assertEquals(20d, coordenada.getLongitud());
	}

	@Test
	void testUnaCoordenadaConoceSuDistanciaHastaOtraCoordenada() {
		coordenada = new Coordenada(40d, 50d);
		coordenada2 = new Coordenada(50d,40d);
		assertEquals(1359.2545257553352, coordenada.distanciaHasta(coordenada2)); 
		
	}
	
	
}

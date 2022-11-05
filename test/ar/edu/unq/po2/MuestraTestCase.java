package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Area.Coordenada;

class MuestraTestCase {

	private Muestra muestra;
	private Usuario usuario;
	private Coordenada coordenada;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		coordenada = mock(Coordenada.class);
		muestra = new Muestra(usuario, coordenada);
	}

	@Test
	void testGetUsuario() {
		assertEquals(muestra.getUsuario(), usuario);
	}

	@Test
	void testGetCoordenada() {
		assertEquals(muestra.getCoordenada(), coordenada);
	}
	
	@Test
	void testGetFechaYHora() {
		assertEquals(muestra.getFechaYHora(), LocalDate.now());
	}
}

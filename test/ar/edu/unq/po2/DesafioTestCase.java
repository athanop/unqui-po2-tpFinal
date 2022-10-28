package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.RestriccionTemporal.RestriccionTemporal;

class DesafioTestCase {

	Desafio desafio;
	Usuario usuario;
	Preferencia preferencia;
	RestriccionTemporal restriccion;
	
	
	@BeforeEach
	void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		usuario = mock(Usuario.class);
		restriccion = mock(RestriccionTemporal.class);
		
	}

	@Test
	void testUnDesafioConoceSuNivelDeCoincidenciaConUnUsuario() {
		desafio = new Desafio(30, 4, 10, restriccion);
		when(preferencia.getCantidadDeMuestras()).thenReturn(15);
		when(preferencia.getDificultad()).thenReturn(2);
		when(preferencia.getRecompensa()).thenReturn(25);
		when(usuario.getPreferencia()).thenReturn(preferencia);
		
		assertEquals(desafio.coincidenciasConLasPreferenciasDeUnUsuario(usuario), 32);
			
	}

}

package ar.edu.unq.po2;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;

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


}

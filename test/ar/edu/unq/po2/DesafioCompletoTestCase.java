package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;
import ar.edu.unq.po2.EstadoDesafio.DesafioCompleto;

class DesafioCompletoTestCase {
	
	Usuario usuario;
	Desafio desafio;
	DesafioUsuario desafioUsuario;
	DesafioCompleto desafioCompleto;
	
	@BeforeEach
	void setUp() throws Exception {
		desafioCompleto = new DesafioCompleto();
	}
	
	@Test
	void testEsDesafioCompleto() {
		fail("Not yet implemented");
	}

}

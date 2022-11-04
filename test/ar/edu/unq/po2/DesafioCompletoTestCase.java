package ar.edu.unq.po2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.EstadoDesafio.DesafioCompleto;

class DesafioCompletoTestCase {

	Usuario usuario;
	Desafio desafio;
	DesafioUsuario desafioUsuario;
	DesafioCompleto desafioCompleto;
	Muestra muestra;
	List<Muestra> muestrasAProbar;

	@BeforeEach
	void setUp() throws Exception {
		desafioCompleto = new DesafioCompleto();

		usuario = mock(Usuario.class);
		desafio = mock(Desafio.class);
		desafioUsuario = mock(DesafioUsuario.class);
		muestra = mock(Muestra.class);
	}

	@Test
	void testElDesafioCompletoSabeSiEstaCompleto() {
		assertTrue(desafioCompleto.esDesafioCompleto(desafio, usuario));
	}

	@Test
	void testElDesfioCompletoConoceSuPorcentajeDeCompletitud() {
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);

		assertEquals(desafioCompleto.porcentajeDeCompletitud(desafio, usuario), 50);
	}

	@Test
	void testElDesfioCompletoNoPuedeActualizarSuDesafioPorqueYaEstaCompleto() throws Exception {

		assertThrows(Exception.class, () -> desafioCompleto.actualizarDesafio(desafioUsuario, usuario));
	}
}

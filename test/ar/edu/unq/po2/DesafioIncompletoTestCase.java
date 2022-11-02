package ar.edu.unq.po2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.EstadoDesafio.DesafioCompleto;
import ar.edu.unq.po2.EstadoDesafio.DesafioIncompleto;

class DesafioIncompletoTestCase {

	Usuario usuario;
	Desafio desafio;
	DesafioUsuario desafioUsuario;
	DesafioIncompleto desafioIncompleto;
	DesafioCompleto desafioCompleto;
	Muestra muestra;
	List<Muestra> muestrasAProbar;

	@BeforeEach
	void setUp() throws Exception {
		desafioIncompleto = new DesafioIncompleto();

		usuario = mock(Usuario.class);
		desafio = mock(Desafio.class);
		desafioUsuario = mock(DesafioUsuario.class);
		muestra = mock(Muestra.class);
		desafioCompleto = mock(DesafioCompleto.class);
	}

	@Test
	void testElDesafioIncompletoSabeSiEstaCompleto() {
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		
		assertFalse(desafioIncompleto.esDesafioCompleto(desafio, usuario));
	}

	@Test
	void testElDesfioIncompletoConoceSuPorcentajeDeCompletitud() {
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(4);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);

		assertEquals(desafioIncompleto.porcentajeDeCompletitud(desafio, usuario), 25);
	}

	@Test
	void testElDesfioIncompletoActualizaSuEstadoAEstadoCompleto() throws Exception {
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(1);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		when(desafioUsuario.getEstado()).thenReturn(desafioIncompleto);
		when(desafioUsuario.getUsuario()).thenReturn(usuario);
		when(desafioUsuario.getDesafio()).thenReturn(desafio);
		desafioIncompleto.actualizarDesafio(desafioUsuario);
		
		assertTrue(desafioIncompleto.esDesafioCompleto(desafio, usuario));
		verify(desafioUsuario, times(1)).setEstado(desafioCompleto);
	}

}

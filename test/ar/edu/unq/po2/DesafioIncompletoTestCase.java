package ar.edu.unq.po2;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Area.Area;
import ar.edu.unq.po2.Area.Coordenada;
import ar.edu.unq.po2.EstadoDesafio.DesafioCompleto;
import ar.edu.unq.po2.EstadoDesafio.DesafioIncompleto;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionDiasDeSemana;

class DesafioIncompletoTestCase {

	Usuario usuario;
	Desafio desafio;
	DesafioUsuario desafioUsuario;
	DesafioIncompleto desafioIncompleto;
	DesafioCompleto desafioCompleto;
	Muestra muestra;
	List<Muestra> muestrasAProbar;
	Coordenada coordenada;
	RestriccionDiasDeSemana restriccion;
	Area area;
	
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

		when(desafioUsuario.getDesafio()).thenReturn(desafio);
		
		assertFalse(desafioIncompleto.esDesafioCompleto(desafioUsuario, usuario));
	}

	@Test
	void testElDesfioIncompletoConoceSuPorcentajeDeCompletitud() {
		
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(4);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);

		when(desafioUsuario.getDesafio()).thenReturn(desafio);
		
		assertEquals(desafioIncompleto.porcentajeDeCompletitud(desafioUsuario, usuario), 25);
	}

}

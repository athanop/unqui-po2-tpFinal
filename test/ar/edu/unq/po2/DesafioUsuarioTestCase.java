package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.EstadoDesafio.DesafioCompleto;
import ar.edu.unq.po2.EstadoDesafio.DesafioIncompleto;

class DesafioUsuarioTestCase {
	
	DesafioUsuario desafioUsuario;
	Usuario usuario;
	Desafio desafio;
	DesafioIncompleto estadoIncompleto;
	DesafioCompleto estadoCompleto;
	Muestra muestra, muestra2;
	List<Muestra> muestrasAProbar;
	
	@BeforeEach
	void setUp() throws Exception {

		usuario = mock(Usuario.class);
		desafio = mock(Desafio.class);
		estadoIncompleto = mock(DesafioIncompleto.class);
		estadoCompleto = mock(DesafioCompleto.class);
		desafioUsuario = new DesafioUsuario(desafio, usuario, 3);		
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
	}
	
	
	@Test
	void testUnDesafioUsuarioConoceAlUsuarioQueAceptoElDesafio() {
		assertEquals(desafioUsuario.getUsuario(), usuario);
	}
	
	@Test
	void testUnDesafioUsuarioConoceAlDesafio() {
		assertEquals(desafioUsuario.getDesafio(), desafio);
	}
	
	@Test
	void testUnDesafioUsuarioConoceSuValoracionCuandoEsMenorOIgualA5() {
		assertEquals(desafioUsuario.getValoracion(), 3);
	}
	
	@Test
	void testUnDesafioUsuarioIndicaCuandoUnaValoracionEsInvalida() throws Exception{
		assertThrows(Exception.class, () -> desafioUsuario.votoDelUsuario(6));
	}
	
	@Test
	void testUnDesafioUsuarioSabeCuandoSeActualizaSuEstado() throws Exception{
		
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2); //necesita 2 muestras para ser completo y el usuario tiene 1
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		desafioUsuario = new DesafioUsuario(desafio, usuario, 3); //estado incompleto
		
		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar); //el usuario ahora tiene dos muestras
		
		desafioUsuario.actualizarDesafio(); //actualiza su estado a completo
		
		
		assertTrue(desafioUsuario.getEstado().esDesafioCompleto(desafio, usuario));
		
	}
	
	@Test
	void testUnDesafioUsuarioSabeCuandoSuEstadoYaEstaCompleto() throws Exception{
		
		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar); 
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		desafioUsuario = new DesafioUsuario(desafio, usuario, 3); 
		
		desafioUsuario.actualizarDesafio(); //intenta actualizar pero ya esta completo
		
		assertThrows(Exception.class, () -> desafioUsuario.actualizarDesafio());
		
	}
	
	@Test
	void testUnDesafioUsuarioRecibeUnaValoracionDeUnUsuario() throws Exception{
		
		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar); 
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		
		desafioUsuario.votoDelUsuario(5);
		
		assertEquals(desafioUsuario.getValoracion(), 5);
	}

	
	@Test
	void testUnDesafioUsuarioRecibeUnaValoracionNoValidaDeUnUsuario() throws Exception{
		
		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar); 
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		
		
		assertThrows(Exception.class, () -> desafioUsuario.votoDelUsuario(6));
	}
	
}

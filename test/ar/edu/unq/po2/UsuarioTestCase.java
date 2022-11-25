package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Recomendacion.PreferenciasEnJuego;

class UsuarioTestCase {

	Usuario usuario;
	Preferencia preferencia;
	DesafioUsuario desafioUsuario, desafioUsuario2;
	Muestra muestra1, muestra2, muestra3;
	Proyecto proyecto, proyecto2;
	PreferenciasEnJuego recomendacionPreferenciasEnJuego;
	Desafio desafio1, desafio2;
	Sistema sistema;
	
	
	@BeforeEach
	void setUp() throws Exception {
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		preferencia = mock(Preferencia.class);
		desafioUsuario = mock(DesafioUsuario.class);
		desafioUsuario2 = mock(DesafioUsuario.class);
		recomendacionPreferenciasEnJuego = mock(PreferenciasEnJuego.class);
		proyecto = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		usuario = new Usuario(preferencia);
	}

	@Test
	void testUnUsuarioConoceCualesSonSusPreferencias() {
		assertEquals(usuario.getPreferencia(), preferencia);
	}

	@Test
	void testUnUsuarioConoceCualesSonSusDesafios() throws Exception {
		List<DesafioUsuario> desafios = Arrays.asList(desafioUsuario, desafioUsuario2);
		usuario.aceptarDesafio(desafioUsuario);
		usuario.aceptarDesafio(desafioUsuario2);
		assertEquals(usuario.getDesafiosUsuario(), desafios);
	}

	@Test
	void testUnUsuarioConoceCualesSonSusMuestrasRecolectadas() throws Exception {
		List<Muestra> muestras = Arrays.asList(muestra1, muestra2);
		usuario.agregarMuestra(muestra1);
		usuario.agregarMuestra(muestra2);
		assertEquals(usuario.getMuestrasRecolectadas(), muestras);
	}


	@Test
	void testUnUsuarioSabeRealizarUnaVotacionAUnDesafio() throws Exception {
		usuario.votarDesafio(desafioUsuario, 5);
		verify(desafioUsuario, times(1)).votoDelUsuario(5);
	}

	@Test
	void testUnUsuarioSabeBuscarDesafiosSegunSuRecomendacion() throws Exception {
		usuario.buscarDesafios(sistema, recomendacionPreferenciasEnJuego);
		verify(recomendacionPreferenciasEnJuego, times(1)).seleccionDeDesafios(sistema, usuario);
	}

	@Test
	void testUnUsuarioAgregaUnaMuestraYNotificaATodosLosDesafiosAceptadosPorElUsuario() throws Exception {
		usuario.aceptarDesafio(desafioUsuario);
		usuario.agregarMuestra(muestra1);
		verify(desafioUsuario).actualizarDesafio(usuario);
		
	}
	
	@Test
	void testUnUsuarioConoceLaSumatoriaDeCompletitudPorDesafio() throws Exception{
		
		usuario = new Usuario(preferencia);
		when(desafioUsuario.porcentajeDeCompletitud(usuario)).thenReturn(33);
		when(desafioUsuario2.porcentajeDeCompletitud(usuario)).thenReturn(11);

		usuario.aceptarDesafio(desafioUsuario);
		usuario.aceptarDesafio(desafioUsuario2);
		
		assertEquals(usuario.promedioDeCompletitudPorDesafio(), 44);
	}
	
	
	@Test
	void testUnUsuarioConoceElPromedioGeneralDeSusDesafios() throws Exception{
		
		usuario = new Usuario(preferencia);
		when(desafioUsuario.porcentajeDeCompletitud(usuario)).thenReturn(33);
		when(desafioUsuario2.porcentajeDeCompletitud(usuario)).thenReturn(11);

		usuario.aceptarDesafio(desafioUsuario);
		usuario.aceptarDesafio(desafioUsuario2);
		
		assertEquals(usuario.promedioDeCompletitudGeneral(), 22);
	}
	
}

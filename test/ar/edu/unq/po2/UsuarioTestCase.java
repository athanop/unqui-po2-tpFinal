package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Recomendacion.PreferenciasEnJuego;
import ar.edu.unq.po2.Recomendacion.Recomendacion;

class UsuarioTestCase {

	Usuario usuario;
	Preferencia preferencia;
	DesafioUsuario desafioUsuario, desafioUsuario2;
	Muestra muestra1, muestra2;
	Proyecto proyecto, proyecto2;
	PreferenciasEnJuego recomendacionPreferenciasEnJuego;
	
	@BeforeEach
	void setUp() throws Exception {
		preferencia = mock(Preferencia.class);
		desafioUsuario = mock(DesafioUsuario.class);
		desafioUsuario2 = mock(DesafioUsuario.class);
		recomendacionPreferenciasEnJuego = mock(PreferenciasEnJuego.class);
		proyecto = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
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
	void testUnUsuarioConoceCualesSonSusMuestrasRecolectadas(){
		List<Muestra> muestras = Arrays.asList(muestra1, muestra2);
		usuario.agregarMuestra(muestra1);
		usuario.agregarMuestra(muestra2);
		assertEquals(usuario.getMuestrasRecolectadas(), muestras);
	}
	
	@Test
	void testUnUsuarioConoceCualesSonSusProyectosActivos(){
		List<Proyecto> proyectos = Arrays.asList(proyecto, proyecto2);
		usuario.registrarseEnProyecto(proyecto);
		usuario.registrarseEnProyecto(proyecto2);
		assertEquals(usuario.getProyectosActivos(), proyectos);
	}
	
	@Test
	void testUnUsuarioSabeRealizarUnaVotacionAUnDesafio() throws Exception{
		usuario.votarDesafio(desafioUsuario, 5);
		verify(desafioUsuario, times(1)).votoDelUsuario(5);
	}


	@Test
	void testUnUsuarioSabeBuscarDesafiosSegunSuRecomendacion() throws Exception{
		usuario.buscarDesafios(recomendacionPreferenciasEnJuego);
		verify(recomendacionPreferenciasEnJuego, times(1)).seleccionDeDesafios(usuario);
	}
	
}

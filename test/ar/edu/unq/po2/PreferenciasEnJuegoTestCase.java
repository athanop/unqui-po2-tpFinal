package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Recomendacion.PreferenciasEnJuego;

class PreferenciasEnJuegoTestCase {

	PreferenciasEnJuego preferenciasEnJuego;
	Preferencia preferencia;
	Desafio desafio, desafio2, desafio3, desafio4, desafio5, desafio6;
	Proyecto proyecto, proyecto2;
	List<Desafio> desafiosAProbar, desafiosARecomendar;
	List<Proyecto> proyectosAProbar;
	DesafioUsuario desafioDelUsuario;
	Usuario usuario;
	Sistema sistema;
	
	@BeforeEach
	void setUp() throws Exception {
		sistema = mock(Sistema.class);
		preferenciasEnJuego = new PreferenciasEnJuego();
		usuario = mock(Usuario.class);
		preferencia = mock(Preferencia.class);
		proyecto = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		desafioDelUsuario = mock(DesafioUsuario.class);
		desafio = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		sistema = mock(Sistema.class);

	}

	@Test
	void testLaSeleccionDeDesafiosContiene5DesafiosConMejorNivelDeCoincidencia() {

		when(preferencia.getCantidadDeMuestras()).thenReturn(15);
		when(preferencia.getDificultad()).thenReturn(2);
		when(preferencia.getRecompensa()).thenReturn(25);
		when(usuario.getPreferencia()).thenReturn(preferencia);

		// valor 32
		when(desafio.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio.getDificultad()).thenReturn(4);
		when(desafio.getRecompensa()).thenReturn(10);

		// valor 33
		when(desafio2.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio2.getDificultad()).thenReturn(5);
		when(desafio2.getRecompensa()).thenReturn(10);

		// valor 34
		when(desafio3.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio3.getDificultad()).thenReturn(6);
		when(desafio3.getRecompensa()).thenReturn(10);

		// valor 35
		when(desafio4.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio4.getDificultad()).thenReturn(7);
		when(desafio4.getRecompensa()).thenReturn(10);

		// valor 36
		when(desafio5.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio5.getDificultad()).thenReturn(8);
		when(desafio5.getRecompensa()).thenReturn(10);

		desafiosAProbar = Arrays.asList(desafio5, desafio2, desafio4, desafio3, desafio6, desafio);
		when(proyecto.getDesafios()).thenReturn(desafiosAProbar);
		proyectosAProbar = Arrays.asList(proyecto);
		when(sistema.getProyectosDeUsuario(usuario)).thenReturn(proyectosAProbar);

		List<Desafio> resultadoOrdenadoEsperado = Arrays.asList(desafio, desafio2, desafio3, desafio4, desafio5);

		assertEquals(5, preferenciasEnJuego.seleccionDeDesafios(sistema, usuario).size());
		assertEquals(resultadoOrdenadoEsperado, preferenciasEnJuego.seleccionDeDesafios(sistema, usuario));
	}

}

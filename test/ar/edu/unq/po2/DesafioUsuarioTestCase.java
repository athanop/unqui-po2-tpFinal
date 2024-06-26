package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

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

class DesafioUsuarioTestCase {

	DesafioUsuario desafioUsuario, desafioUsuario1;
	Usuario usuario;
	Desafio desafio;
	DesafioIncompleto estadoIncompleto;
	DesafioCompleto estadoCompleto;
	Muestra muestra, muestra2;
	List<Muestra> muestrasAProbar;
	Coordenada coordenada;
	RestriccionDiasDeSemana restriccion;
	Area area;
	LocalDate fecha;
	@BeforeEach
	void setUp() throws Exception {
		coordenada = mock(Coordenada.class);
		usuario = mock(Usuario.class);
		desafio = mock(Desafio.class);
		estadoIncompleto = mock(DesafioIncompleto.class);
		estadoCompleto = mock(DesafioCompleto.class);
		desafioUsuario = new DesafioUsuario(desafio, 3,  LocalDate.of(2022, 1, 1));
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		restriccion = mock(RestriccionDiasDeSemana.class);
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
	void testUnDesafioUsuarioIndicaCuandoUnaValoracionEsInvalida() throws Exception {
		desafioUsuario = new DesafioUsuario(desafio, 3,  LocalDate.of(2022, 1, 1));
		assertThrows(Exception.class, () -> desafioUsuario.votoDelUsuario(6));
	}
	
	@Test
	void testUnDesafioUsuarioConoceSuFechaDeCompletitud() {
		desafioUsuario.setFechaCompletitud(LocalDate.now());
		assertEquals(desafioUsuario.getFechaCompletitud(), LocalDate.now());
	}
	
	@Test
	void testUnDesafioUsuarioSabeCuandoSeActualizaSuEstado() throws Exception {

		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2); // necesita 2 muestras para ser completo y el usuario
																// tiene 1
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2022, 1, 1)); // estado incompleto

		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar); // el usuario ahora tiene dos muestras

		desafioUsuario.actualizarDesafio(usuario); // actualiza su estado a completo

		assertTrue(desafioUsuario.getEstado().esDesafioCompleto(desafioUsuario, usuario));

	}
	
	
	@Test
	void testUnDesafioUsuarioSabeCuandoSuEstadoYaEstaCompleto() throws Exception {

		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2022, 1, 1));

		desafioUsuario.actualizarDesafio(usuario); // intenta actualizar pero ya esta completo

		assertThrows(Exception.class, () -> desafioUsuario.actualizarDesafio(usuario));

	}
	
	
	@Test
	void testUnDesafioUsuarioRecibeUnaValoracionDeUnUsuario() throws Exception {
		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);
		
		desafioUsuario1 = new DesafioUsuario(desafio, 1,  LocalDate.of(2022, 1, 1));
		desafioUsuario1.actualizarDesafio(usuario);
		
		desafioUsuario1.votoDelUsuario(5);

		assertEquals(desafioUsuario1.getValoracion(), 5);
	}

	
	@Test
	void testUnDesafioUsuarioRecibeUnaValoracionNoValidaDeUnUsuario() throws Exception {

		muestrasAProbar = Arrays.asList(muestra, muestra2);
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2);

		assertThrows(Exception.class, () -> desafioUsuario.votoDelUsuario(6));
	}
	
	
	@Test 
	void unDesafioDeUsuarioConoceLaCantidadDeMuestrasValidasDeUnUsuario(){
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2024, 1, 1));
		
		when(muestra.getCoordenada()).thenReturn(coordenada);
		when(muestra.getFechaYHora()).thenReturn(LocalDate.of(2022, 12, 5));
		when(muestra.getUsuario()).thenReturn(usuario);
		
		when(muestra2.getCoordenada()).thenReturn(coordenada);
		when(muestra2.getFechaYHora()).thenReturn(LocalDate.of(2023, 12, 5));
		when(muestra2.getUsuario()).thenReturn(usuario);
		
		when(desafioUsuario.muestraDentroDeArea(muestra)).thenReturn(true);
		when(desafioUsuario.muestraDentroDeArea(muestra2)).thenReturn(true);
		when(desafioUsuario.muestraDentroDeRestriccionTemporal(muestra)).thenReturn(true);
		when(desafioUsuario.muestraDentroDeRestriccionTemporal(muestra2)).thenReturn(false);
		
		muestrasAProbar = Arrays.asList(muestra, muestra2);

		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		
		assertTrue(desafioUsuario.muestraDentroDeAreaYFecha(muestra));
		assertEquals(desafioUsuario.cantidadDeMuestrasValidas(usuario), 1);

	}
	
	@Test
	void testUnDesafioDeUsuarioValidaUnaMuestraPorArea() {
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2024, 1, 1));
		when(desafio.coordenadaCumpleAreaDesafio(coordenada)).thenReturn(true);
		when(muestra.getCoordenada()).thenReturn(coordenada);
		
		assertTrue(desafioUsuario.muestraDentroDeArea(muestra));
	}
	
	@Test
	void testUnDesafioDeUsuarioValidaUnaMuestraPorFecha() {
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2024, 1, 1));
		when(muestra.getFechaYHora()).thenReturn(LocalDate.of(2022, 12, 5));
		
		assertTrue(desafioUsuario.muestraDentroDeFecha(muestra));
	}
	
	@Test
	void testUnDesafioDeUsuarioValidaUnaMuestraPorRestriccionTemporal() {
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2024, 1, 1));
		when(desafio.fechaCumpleRestriccionTemporal(fecha)).thenReturn(true);
		
		assertTrue(desafioUsuario.muestraDentroDeRestriccionTemporal(muestra));
	}
	
	@Test
	void testUnDesafioDeUsuarioValidaUnaMuestra() {
		desafioUsuario = new DesafioUsuario(desafio, 3, LocalDate.of(2024, 1, 1));
		when(muestra.getCoordenada()).thenReturn(coordenada);
		when(muestra.getFechaYHora()).thenReturn(LocalDate.of(2022, 12, 5));
		when(muestra.getUsuario()).thenReturn(usuario);
		when(desafioUsuario.muestraDentroDeArea(muestra)).thenReturn(true);
		when(desafioUsuario.muestraDentroDeRestriccionTemporal(muestra)).thenReturn(true);
		
		assertTrue(desafioUsuario.muestraDentroDeAreaYFecha(muestra));
	}
	
	@Test
	void testUnDesafioUsuarioConoceElPorcentajeDeCompletitudDelDesafioDeUnUsuario() {
		muestrasAProbar = Arrays.asList(muestra);
		when(desafio.getMuestrasRecolectadas()).thenReturn(2); 
		when(usuario.getMuestrasRecolectadas()).thenReturn(muestrasAProbar);
		
		desafioUsuario = new DesafioUsuario(desafio, 3,  LocalDate.of(2022, 1, 1));
		
		
		assertEquals(desafioUsuario.porcentajeDeCompletitud(usuario), 50);
	}
	
	
}

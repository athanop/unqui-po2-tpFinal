package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.Recomendacion.Favoritos;

class FavoritoTestCase {

	Favoritos favoritos;
	Desafio desafio1, desafio2, desafio3, desafio4, desafio5, desafio6, desafio7;
	Preferencia preferencia;
	Proyecto proyecto, proyecto2;
	List<Desafio> desafiosAProbar, desafiosARecomendar;
	List<Proyecto> proyectosAProbar;
	DesafioUsuario desafioFavoritoDelUsuario, desafioDelUsuario2, desafioDelUsuario3, desafioDelUsuario4,desafioDelUsuario5;
	Usuario usuario;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		favoritos = new Favoritos();
		usuario = mock(Usuario.class);
		preferencia = mock(Preferencia.class);
		proyecto = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		desafioFavoritoDelUsuario = mock(DesafioUsuario.class);
		desafioDelUsuario2 = mock(DesafioUsuario.class);
		desafioDelUsuario3 = mock(DesafioUsuario.class);
		desafioDelUsuario4 = mock(DesafioUsuario.class);
		desafioDelUsuario5 = mock(DesafioUsuario.class);
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		desafio7 = mock(Desafio.class);
		
		
	}

	
	@Test
	void testLaSeleccionDeDesafiosFavoritosContiene5DesafiosConMejorCoincidenciaOrdenadosPorSimilitud() {
		List<DesafioUsuario> desafiosDelUsuario = new ArrayList<DesafioUsuario>();

		when(desafioFavoritoDelUsuario.getValoracion()).thenReturn(5);		
		when(desafioFavoritoDelUsuario.getDesafio()).thenReturn(desafio1);
		when(usuario.getDesafiosUsuario()).thenReturn(desafiosDelUsuario);
		desafiosDelUsuario.add(desafioFavoritoDelUsuario);
		
		when(preferencia.getCantidadDeMuestras()).thenReturn(15);
		when(preferencia.getDificultad()).thenReturn(2);
		when(preferencia.getRecompensa()).thenReturn(25);
		when(usuario.getPreferencia()).thenReturn(preferencia);
		
		
		//desafio que mas le gusto
		when(desafio1.getMuestrasRecolectadas()).thenReturn(15);
		when(desafio1.getDificultad()).thenReturn(2);
		when(desafio1.getRecompensa()).thenReturn(25);
		
		//10
		when(desafio2.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio2.getDificultad()).thenReturn(4);
		when(desafio2.getRecompensa()).thenReturn(10);
	
		//9
		when(desafio3.getMuestrasRecolectadas()).thenReturn(10);
		when(desafio3.getDificultad()).thenReturn(2);
		when(desafio3.getRecompensa()).thenReturn(2);
		
		//6
		when(desafio4.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio4.getDificultad()).thenReturn(4);
		when(desafio4.getRecompensa()).thenReturn(23);
		
		//8
		when(desafio5.getMuestrasRecolectadas()).thenReturn(3);
		when(desafio5.getDificultad()).thenReturn(1);
		when(desafio5.getRecompensa()).thenReturn(14);
		
		//12
		when(desafio6.getMuestrasRecolectadas()).thenReturn(2);
		when(desafio6.getDificultad()).thenReturn(1);
		when(desafio6.getRecompensa()).thenReturn(3);
				
		//11
		when(desafio7.getMuestrasRecolectadas()).thenReturn(3);
		when(desafio7.getDificultad()).thenReturn(3);
		when(desafio7.getRecompensa()).thenReturn(3);
		
		desafiosAProbar = Arrays.asList(desafio4, desafio2, desafio3, desafio5, desafio6, desafio7);	
		when(proyecto.getDesafios()).thenReturn(desafiosAProbar);
		proyectosAProbar = Arrays.asList(proyecto);
		when(usuario.getProyectosActivos()).thenReturn(proyectosAProbar);
			
		List<Desafio> resultadoOrdenadoEsperado = Arrays.asList(desafio4, desafio5, desafio3, desafio2, desafio7);
		
		assertEquals(favoritos.seleccionDeDesafios(usuario), resultadoOrdenadoEsperado);
	}
}

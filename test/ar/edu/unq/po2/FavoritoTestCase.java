package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
	DesafioUsuario desafioFavoritoDelUsuario, desafioDelUsuario2;
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
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		desafio7 = mock(Desafio.class);
		
		
	}

	@Test
	void testLaRecomendacionPorFavoritosConoceElDesafioFavoritoDelUsuario() {
		List<DesafioUsuario> desafiosDelUsuario = new ArrayList<DesafioUsuario>();
		
		when(desafioFavoritoDelUsuario.getValoracion()).thenReturn(5);
		when(desafioDelUsuario2.getValoracion()).thenReturn(3);
		
		when(desafioFavoritoDelUsuario.getDesafio()).thenReturn(desafio1);
		when(desafioDelUsuario2.getDesafio()).thenReturn(desafio2);
		
		desafiosDelUsuario.add(desafioFavoritoDelUsuario);
		desafiosDelUsuario.add(desafioDelUsuario2);
		
		when(usuario.getDesafiosUsuario()).thenReturn(desafiosDelUsuario);
		
		assertEquals(favoritos.desafioFavoritoDelUsuario(usuario), desafio1);
	}

	@Test
	void testLaRecomendacionPorFavoritosConoceLaSimilitudEntreDosDesafios() {
		
		when(desafio1.getMuestrasRecolectadas()).thenReturn(15);
		when(desafio1.getDificultad()).thenReturn(2);
		when(desafio1.getRecompensa()).thenReturn(25);
				
		when(desafio2.getMuestrasRecolectadas()).thenReturn(30);
		when(desafio2.getDificultad()).thenReturn(4);
		when(desafio2.getRecompensa()).thenReturn(10);
		
		assertEquals(favoritos.similitudEntreDesafios(desafio1, desafio2), 10,6);
	}
	
	
	
	
	
	
}

package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
	DesafioUsuario desafioFavoritoDelUsuario;
	Usuario usuario;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
		favoritos = new Favoritos();
		usuario = mock(Usuario.class);
		preferencia = mock(Preferencia.class);
		proyecto = mock(Proyecto.class);
		proyecto2 = mock(Proyecto.class);
		desafioFavoritoDelUsuario = mock(DesafioUsuario.class);
		desafio1 = mock(Desafio.class);
		desafio2 = mock(Desafio.class);
		desafio3 = mock(Desafio.class);
		desafio4 = mock(Desafio.class);
		desafio5 = mock(Desafio.class);
		desafio6 = mock(Desafio.class);
		desafio7 = mock(Desafio.class);

		
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

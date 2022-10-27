package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProyectoTestCase {

	Proyecto proyecto;
	Categoria categoriaAstronomia, categoriaBiologia;
	Usuario usuario;
	Muestra muestra, muestra2;
	Desafio desafio;
	
	@BeforeEach
	void setUp() throws Exception {
	
		proyecto = new Proyecto("Proyecto Arboles", "descripcion");
		categoriaAstronomia = mock(Categoria.class);
		categoriaBiologia = mock(Categoria.class);
		usuario = mock(Usuario.class);
		muestra = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		desafio = mock(Desafio.class);
	}

	@Test
	void testUnProyectoConoceSuNombreYDescripcion() {
		assertEquals("Proyecto Arboles", proyecto.getNombre());
		assertEquals("descripcion", proyecto.getDescripcion());
	}

	@Test
	void testUnProyectoConoceLaCategoriaALaQuePertenece() {
		proyecto.agregarCategoria(categoriaAstronomia);
		assertTrue(proyecto.getCategorias().contains(categoriaAstronomia));
		assertFalse(proyecto.getCategorias().contains(categoriaBiologia));
	}
	
	@Test
	void testUnProyectoConoceLaCantidadDeUsuariosActivos() {
		proyecto.agregarUsuario(usuario);
		assertEquals(proyecto.getUsuarios().size(), 1);
	}
	
	@Test
	void testUnProyectoConoceLasMuestrasQueFueronRecolectadas() {
		proyecto.agregarMuestra(muestra);
		assertTrue(proyecto.getMuestrasRecolectadas().contains(muestra));
		assertFalse(proyecto.getMuestrasRecolectadas().contains(muestra2));
	}
	
	@Test
	void testUnProyectoConoceLaCantidadDeDesafiosQueContiene() {
		proyecto.agregarDesafio(desafio);
		assertEquals(proyecto.getDesafios().size(), 1);
	}
}

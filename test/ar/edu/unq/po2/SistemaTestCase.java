package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTestCase {

	private Sistema sist;
	private Proyecto proy1;
	private Categoria cat1, cat2;
	
	@BeforeEach
	void setUp() throws Exception {
		sist = new Sistema();
		proy1 = mock(Proyecto.class);
		cat1 = mock(Categoria.class);
		cat2 = mock(Categoria.class);
		sist.agregarProyecto(proy1);
		sist.agregarCategoria(cat1);
		sist.agregarCategoria(cat2);
	}
	
	@Test
	void testGetProyectos() {
		assertEquals(sist.getProyectos().size(), 1);
	}

	@Test
	void testGetCategorias() {
		assertEquals(sist.getCategorias().size(), 2);
	}
}

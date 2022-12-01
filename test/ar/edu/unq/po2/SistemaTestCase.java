package ar.edu.unq.po2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTestCase {

	private Sistema sist;
	private Proyecto proy1, proy2, proy3;
	private Categoria cat1, cat2;
	private Usuario user;
	
	@BeforeEach
	void setUp() throws Exception {
		sist = new Sistema();
		proy1 = mock(Proyecto.class);
		proy2 = mock(Proyecto.class);
		proy3 = mock(Proyecto.class);
		cat1 = mock(Categoria.class);
		cat2 = mock(Categoria.class);
		user = mock(Usuario.class);
		sist.agregarProyecto(proy1);
		sist.agregarProyecto(proy2);
		sist.agregarProyecto(proy3);
		sist.agregarCategoria(cat1);
		sist.agregarCategoria(cat2);
	}
	
	@Test
	void testGetProyectos() {
		assertEquals(sist.getProyectos().size(), 3);
		assertTrue(sist.getProyectos().contains(proy1));
		assertTrue(sist.getProyectos().contains(proy2));
		assertTrue(sist.getProyectos().contains(proy3));
	}

	@Test
	void testGetCategorias() {
		assertEquals(sist.getCategorias().size(), 2);
		assertTrue(sist.getCategorias().contains(cat1));
		assertTrue(sist.getCategorias().contains(cat2));
	}
	
	@Test
	void testGetProyectosDeUsuario() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(user);
		when(proy1.getUsuarios()).thenReturn(usuarios);
		when(proy2.getUsuarios()).thenReturn(usuarios);
		assertEquals(sist.getProyectosDeUsuario(user).size(), 2);
		assertTrue(sist.getProyectosDeUsuario(user).contains(proy1));
		assertTrue(sist.getProyectosDeUsuario(user).contains(proy2));
		assertFalse(sist.getProyectosDeUsuario(user).contains(proy3));
	}
}

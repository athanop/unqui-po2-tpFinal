package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.BusquedaProyecto.ANDComposite;
import ar.edu.unq.po2.BusquedaProyecto.BusquedaComponent;
import ar.edu.unq.po2.BusquedaProyecto.FiltroPorCategoriaInclusion;
import ar.edu.unq.po2.BusquedaProyecto.FiltroPorTexto;

class ANDCompositeTestCase {

	private ANDComposite andc;
	private BusquedaComponent filtro1, filtro2;
	private Proyecto proy1, proy2, proy3;
	private Categoria cat1, cat2, cat3, cat4, cat5;
	private List<Proyecto> proyectos = new ArrayList<>();
	private List<Categoria> categorias = new ArrayList<>();
	private List<Categoria> catproy1 = new ArrayList<>();
	private List<Categoria> catproy2 = new ArrayList<>();
	private List<Categoria> catproy3 = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		filtro1 = new FiltroPorTexto("Ciencia");
		filtro2 = new FiltroPorCategoriaInclusion(categorias);
		andc = new ANDComposite(filtro1, filtro2);
		proy1 = mock(Proyecto.class);
		proy2 = mock(Proyecto.class);
		proy3 = mock(Proyecto.class);
		cat1 = mock(Categoria.class);
		cat2 = mock(Categoria.class);
		cat3 = mock(Categoria.class);
		cat4 = mock(Categoria.class);
		cat5 = mock(Categoria.class);
		when(cat1.getTipoCategoria()).thenReturn("Astronomia");
		when(cat2.getTipoCategoria()).thenReturn("Botanica");
		when(cat3.getTipoCategoria()).thenReturn("Ciencia");
		when(cat4.getTipoCategoria()).thenReturn("Fisica");
		when(cat5.getTipoCategoria()).thenReturn("Quimica");
		proyectos.add(proy1);
		proyectos.add(proy2);
		proyectos.add(proy3);
		catproy1.add(cat1);
		catproy1.add(cat3);
		when(proy1.getCategorias()).thenReturn(catproy1);
		catproy2.add(cat2);
		when(proy2.getCategorias()).thenReturn(catproy2);
		catproy3.add(cat3);
		catproy3.add(cat4);
		catproy3.add(cat5);
		when(proy3.getCategorias()).thenReturn(catproy3);
		categorias.add(cat1);
		categorias.add(cat3);
		when(proy1.getNombre()).thenReturn("Ciencia Astronomica");
		when(proy2.getNombre()).thenReturn("Arboles");
		when(proy3.getNombre()).thenReturn("Ciencia FisicoQuimica");
	}
	@Test
	void testANDComposite() {
		assertTrue(andc.filtrados(proyectos).contains(proy1));
		assertFalse(andc.filtrados(proyectos).contains(proy2));
		assertFalse(andc.filtrados(proyectos).contains(proy3));
	}

}

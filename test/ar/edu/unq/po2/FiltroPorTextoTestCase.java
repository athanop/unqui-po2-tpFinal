package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.BusquedaProyecto.FiltroPorTexto;

class FiltroPorTextoTestCase {

	private FiltroPorTexto filtro;
	private Proyecto proy1, proy2, proy3;
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	
	@BeforeEach
	void setUp() throws Exception {
		proy1 = mock(Proyecto.class);
		proy2 = mock(Proyecto.class);
		proy3 = mock(Proyecto.class);
		when(proy1.getNombre()).thenReturn("Arbolito");
		when(proy2.getNombre()).thenReturn("Flor");
		when(proy3.getNombre()).thenReturn("Arboleda");
		proyectos.add(proy1);
		proyectos.add(proy2);
		proyectos.add(proy3);
		filtro = new FiltroPorTexto("Arbol");
	}
	@Test
	void testBusquedaFiltroPorTexto() {
		assertTrue(filtro.filtrados(proyectos).contains(proy1));
		assertFalse(filtro.filtrados(proyectos).contains(proy2));
		assertTrue(filtro.filtrados(proyectos).contains(proy3));
	}

}

package ar.edu.unq.po2.BusquedaProyecto;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Categoria;
import ar.edu.unq.po2.Proyecto;

/**
 * Clase que modela la busqueda de proyectos con el filtro de categoria que se incluye.
 */
public class FiltroPorCategoriaInclusion implements BusquedaComponent {
	private List<Categoria> categorias;

	public FiltroPorCategoriaInclusion(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos) {
		return proyectos.stream().filter(p -> p.getCategorias().containsAll(this.categorias)).collect(Collectors.toList());
	}
}

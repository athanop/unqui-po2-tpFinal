package ar.edu.unq.po2.BusquedaProyecto;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Proyecto;

/**
 * Clase que modela la busqueda de proyectos con el filtro de texto en titulos.
 */
public class FiltroPorTexto implements BusquedaComponent {
	private String texto;

	public FiltroPorTexto(String text) {
		this.texto = text;
	}

	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos) {
		return proyectos.stream().filter(p -> p.getNombre().contains(this.texto)).collect(Collectors.toList());
	}

}

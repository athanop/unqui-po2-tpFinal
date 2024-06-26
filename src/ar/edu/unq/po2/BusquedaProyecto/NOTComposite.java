package ar.edu.unq.po2.BusquedaProyecto;

import java.util.List;

import ar.edu.unq.po2.Proyecto;

/**
 * Clase que modela la busqueda de proyectos con el filtro NOT en el patron
 * Composite.
 *
 */
public class NOTComposite implements BusquedaComponent {

	private BusquedaComponent filtro;

	public NOTComposite(BusquedaComponent filtro) {
		this.filtro = filtro;
	}

	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos) {
		List<Proyecto> filtrada = filtro.filtrados(proyectos);
		return proyectos.stream().filter(p -> !filtrada.contains(p)).toList();
	}
}

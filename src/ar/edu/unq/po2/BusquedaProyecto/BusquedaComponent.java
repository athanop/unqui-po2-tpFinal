package ar.edu.unq.po2.BusquedaProyecto;

import java.util.List;

import ar.edu.unq.po2.Proyecto;

/**
 * Interfaz que modela la busqueda de proyectos con distintos filtros con un
 * patron Composite.
 * 
 * @author ivanapr
 *
 */
public interface BusquedaComponent {

	public List<Proyecto> filtrados(List<Proyecto> proyectos);
}

package ar.edu.unq.po2.BusquedaProyecto;

import java.util.List;

import ar.edu.unq.po2.Proyecto;

/**
 * Clase que modela la busqueda de proyectos con el filtro AND en el patron
 * Composite.
 * 
 * @author ivanapr
 *
 */
public class ANDComposite implements BusquedaComponent {

	private BusquedaComponent filtro1;
	private BusquedaComponent filtro2;

	public ANDComposite(BusquedaComponent filtro1, BusquedaComponent filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos) {
		List<Proyecto> filtrados1 = filtro1.filtrados(proyectos);
		List<Proyecto> filtrados2 = filtro2.filtrados(filtrados1);
		return filtrados2;
	}
}

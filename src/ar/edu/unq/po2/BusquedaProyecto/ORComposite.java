package ar.edu.unq.po2.BusquedaProyecto;
import java.util.List;
import ar.edu.unq.po2.Proyecto;

/**
 * Clase que modela la busqueda de proyectos con el filtro OR en el patron Composite.
 * 
 * @author ivanapr
 *
 */
public class ORComposite extends BusquedaComponent {
	
	private BusquedaComponent filtro1;
	private BusquedaComponent filtro2;
	
	public ORComposite(BusquedaComponent filtro1, BusquedaComponent filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}
	
	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos) {
		List<Proyecto> filtrados1 = filtro1.filtrados(proyectos);
		List<Proyecto> filtrados2 = filtro2.filtrados(proyectos);
		List<Proyecto> filtradosOr = new ArrayList<Proyecto>(filtrados1); // Al resultado final se le agregan los elementos que cumplen la primera condicion
		filtrados2.removeAll(filtrados1); // Se quitan los repetidos que pueda haber entre ambas condiciones
		filtradosOr.addAll(filtrados2); // Se agregan los elementos que cumplen la segunda condicion
		return filtradosOr;
	}
}

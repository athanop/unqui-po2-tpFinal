package ar.edu.unq.po2.BusquedaProyecto;
import java.util.List;
import ar.edu.unq.po2.Proyecto;

/**
 * Clase que modela la busqueda de proyectos con el filtro OR en el patron Composite.
 * 
 * @author ivanapr
 *
 */
public class NOTComposite implements BusquedaComponent {
	
}
	private BusquedaComponent filtro;
	
	public NOTComposite(BusquedaComponent filtro) {
		this.filtro = filtro;
	}
	
	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos){
		 return List<Proyecto> filtrados = filtro.filtrados(proyectos); // Revisar
	}
}

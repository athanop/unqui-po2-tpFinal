package ar.edu.unq.po2.BusquedaProyecto;
package ar.edu.unq.po2.Proyecto;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que modela la busqueda de proyectos con el filtro de categorias.
 */
public class FiltroPorCategoria implements BusquedaComponent {
	private Categoria categoria;
	public FiltroPorCategoria(Categoria cat) {
		this.categoria = cat;
	}
	@Override
	public List<Proyecto> filtrados(List<Proyecto> proyectos) {
		return proyectos.stream().filter(p -> p.getCategorias().contains(this.categoria)).collect(Collectors.toList());
	}
}

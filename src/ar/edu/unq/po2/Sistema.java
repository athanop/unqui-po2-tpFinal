package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase que modela el sistema.
 * 
 */
public class Sistema {
	/**
	 * Un sistema a representar. Una lista de todos los proyectos del sistema. Una
	 * lista de todas las categorias del sistema.
	 */
	private List<Proyecto> proyectos;
	private List<Categoria> categorias;

	/**
	 * Constructor. Crea una unica instancia de Sistema.
	 */
	Sistema() {
		this.proyectos = new ArrayList<Proyecto>();
		this.categorias = new ArrayList<Categoria>();
	}

	

	/**
	 * Obtiene la lista de Proyectos que hay en el Sistema.
	 * 
	 * @return una lista de Proyectos en el Sistema.
	 */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	/**
	 * Obtiene la lista de Categorias que hay en el Sistema.
	 * 
	 * @return una lista de Categorias en el Sistema.
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * Agrega un Proyecto al Sistema.
	 * 
	 * @param proyecto es el Proyecto a agregar al Sistema.
	 */
	public void agregarProyecto(Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	/**
	 * Agrega una Categoria al Sistema.
	 * 
	 * @param categoria es la Categoria a agregar al Sistema.
	 */
	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);
	}



	public List<Proyecto> getProyectosDeUsuario(Usuario usuario) {
		return this.getProyectos().stream().filter(p -> p.getUsuarios().contains(usuario)).collect(Collectors.toList());
	}
}

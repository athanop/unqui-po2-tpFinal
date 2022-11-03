package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de representar un Proyecto.
 */
public class Proyecto {

	private String nombre;
	private String descripcion;
	private List<Categoria> categorias;
	private List<Usuario> usuarios;
	private List<Muestra> muestrasRecolectadas;
	private List<Desafio> desafios;

	/**
	 * Getter descripcion
	 * 
	 * @return Devuelve la descripcion del proyecto.
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Getter nombre
	 * 
	 * @return Devuelve el nombre del proyecto.
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Getter categorias
	 * 
	 * @return Devuelve la lista de categorias del proyecto.
	 */
	public List<Categoria> getCategorias() {
		return categorias;
	}

	/**
	 * Getter usuarios
	 * 
	 * @return Devuelve la lista de usuarios del proyecto.
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Getter muestras
	 * 
	 * @return Devuelve la lista de muestras recolectadas por los usuarios del proyecto.
	 */
	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	/**
	 * Getter desafios
	 * 
	 * @return Devuelve la lista de desafios del proyecto.
	 */
	public List<Desafio> getDesafios() {
		return desafios;
	}

	/**
	 * Establece la lista de desafios que pertenecen al proyecto.
	 * @param desafios, es la lista de desafios.
	 */
	public void setDesafios(List<Desafio> desafios) {
		this.desafios = desafios;
	}

	/**
	 * Constructor de Proyecto.
	 * 
	 * @param nombre, es el titulo del Proyecto.
	 * @param descripcion, es la descripcion del Proyecto.
	 */
	public Proyecto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categorias = new ArrayList<Categoria>();
		this.usuarios = new ArrayList<Usuario>();
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.setDesafios(new ArrayList<Desafio>());
	}

	/**
	 * Agrega una Categoria al Proyecto
	 * @param categoria es la Categoria a agregar al Proyecto.
	 */
	public void agregarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}

	/**
	 * Agrega un Usuario al Proyecto
	 * @param usuario es el Usuario a agregar al Proyecto.
	 */
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	/**
	 * Agrega una Muestra al Proyecto
	 * @param muestra es la Muestra a agregar al Proyecto.
	 */
	public void agregarMuestra(Muestra muestra) {
		this.muestrasRecolectadas.add(muestra);
	}

	/**
	 * Agrega un Desafio al Proyecto
	 * @param desafio es el Desafio a agregar al Proyecto.
	 */
	public void agregarDesafio(Desafio desafio) {
		this.desafios.add(desafio);
	}

}

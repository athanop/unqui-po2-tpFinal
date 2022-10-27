package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {

	private String nombre;
	private String descripcion;
	private List<Categoria> categorias;
	private List<Usuario> usuarios;
	private List<Muestra> muestrasRecolectadas;
	private List<Desafio> desafios;
	
	//-----getters-----
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}
	
	public List<Desafio> getDesafios() {
		return desafios;
	}
	
	//-----constructor-----
	
	public Proyecto(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categorias = new ArrayList<Categoria>();
		this.usuarios = new ArrayList<Usuario>();
		this.muestrasRecolectadas = new ArrayList<Muestra>();
		this.desafios = new ArrayList<Desafio>();
	}

	//adds para categoria, usuario y muestra
	public void agregarCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}

	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public void agregarMuestra(Muestra muestra) {
		this.muestrasRecolectadas.add(muestra);
	}

	public void agregarDesafio(Desafio desafio) {
		this.desafios.add(desafio);
	}

	

	
	
	

}

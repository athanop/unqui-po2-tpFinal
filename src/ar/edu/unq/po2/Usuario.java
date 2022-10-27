package ar.edu.unq.po2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Recomendacion.RecomendacionDeDesafio;

public class Usuario {

	private List<Muestra> muestrasRecolectadas;
	private List<Proyecto> proyectosActivos;
	private Preferencia preferencia;
	private List<DesafioUsuario> desafiosUsuario;

	public List<Proyecto> getProyectosActivos() {
		return proyectosActivos;
	}

	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}
	
	public List<DesafioUsuario> getDesafiosUsuario() {
		return desafiosUsuario;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public List<Desafio> buscarDesafios(RecomendacionDeDesafio recomendacion) {
		List<Desafio> desafiosFiltrados = new ArrayList<Desafio>();
		for(Proyecto proyecto:this.getProyectosActivos()) {
			desafiosFiltrados.addAll(recomendacion.seleccionDeDesafios(preferencia, proyecto)); 
		}
		return desafiosFiltrados;
	}
	
	public void aceptarDesafio(DesafioUsuario desafioUsuario) throws Exception {
		if (!this.getDesafiosUsuario().contains(desafioUsuario)) {
			getDesafiosUsuario().add(desafioUsuario);
		}
	}
}

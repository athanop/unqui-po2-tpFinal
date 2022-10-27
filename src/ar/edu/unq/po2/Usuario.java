package ar.edu.unq.po2;

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

	public Preferencia getPreferencia() {
		return preferencia;
	}

	public List<Proyecto> buscarDesafios(RecomendacionDeDesafio recomendacion) {
		
		for(Proyecto proyecto:this.getProyectosActivos()) {
			recomendacion.seleccionDeDesafios(preferencia, proyecto); //lo dejo asi lo tengo q modificar
		}
		return 
	}

	

	public List<DesafioUsuario> getDesafiosUsuario() {
		return desafiosUsuario;
	}
	
	public void aceptarDesafio(DesafioUsuario desafioUsuario) throws Exception {
		if (!this.getDesafiosUsuario().contains(desafioUsuario)) {
			getDesafiosUsuario().add(desafioUsuario);
		}
	}
}

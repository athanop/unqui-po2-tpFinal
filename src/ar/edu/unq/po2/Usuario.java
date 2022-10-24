package ar.edu.unq.po2;

import java.util.List;

import ar.edu.unq.po2.Recomendacion.RecomendacionDeDesafio;

public class Usuario {

	private List<Muestra> muestrasRecolectadas;
	private List<Proyecto> proyectosActivos;
	private Preferencia preferencia;
	

	public List<Proyecto> getProyectosActivos() {
		return proyectosActivos;
	}
	
	public List<Muestra> getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	public Preferencia getPreferencia() {
		return preferencia;
	}
	
	
	public List<Desafio> buscarDesafios(List<Desafio> desafios, RecomendacionDeDesafio recomendacion){
		return recomendacion.seleccionDeDesafios(desafios);
	}
	
	
	
	
	
	
}

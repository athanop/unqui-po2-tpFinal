package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Preferencia;

public class PreferenciasEnJuego implements RecomendacionDeDesafio{

	@Override
	public List<Desafio> seleccionDeDesafios(Preferencia preferencia, List<Desafio> desafios) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		for(Desafio des:desafios) {
			
			
			//falta completar
		}
		
		return seleccion;
	}

	
	

}

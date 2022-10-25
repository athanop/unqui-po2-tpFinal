package ar.edu.unq.po2.Recomendacion;

import java.util.List;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Preferencia;

public interface RecomendacionDeDesafio {

	public List<Desafio> seleccionDeDesafios(Preferencia preferencia, List<Desafio> desafios);
	
}

package ar.edu.unq.po2.Recomendacion;

import java.util.List;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Preferencia;
import ar.edu.unq.po2.Proyecto;
import ar.edu.unq.po2.Usuario;

public interface RecomendacionDeDesafio {

	public List<Desafio> seleccionDeDesafios(Usuario usuario);

}

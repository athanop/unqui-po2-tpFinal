package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Usuario;

public class PreferenciasEnJuego extends Recomendacion {

	@Override
	public List<Desafio> seleccionDeDesafios(Usuario usuario) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		seleccion = this.desafiosDeTodosLosProyectosDelUsuario(usuario);
		seleccion = this.removerDesafiosQueYaContieneElUsuario(usuario, seleccion);
		seleccion = this.ordenarDesafiosPorNivelDeCoincidencia(seleccion, usuario);
		return seleccion.stream().limit(5).toList();
	}

}

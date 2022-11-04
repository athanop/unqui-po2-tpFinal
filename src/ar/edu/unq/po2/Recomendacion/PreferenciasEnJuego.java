package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Usuario;

public class PreferenciasEnJuego extends Recomendacion {

	@Override
	public List<Desafio> seleccionDeDesafios(Usuario usuario) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		seleccion = this.filtrarYRemoverDesafiosQueYaConoceElUsuarioDeSusProyectosActivos(usuario, seleccion);
		seleccion = this.ordenarDesafios(usuario, seleccion);
		return seleccion.stream().limit(5).toList();
	}

	@Override
	public List<Desafio> ordenarDesafios(Usuario usuario, List<Desafio> desafiosSeleccionados) {
		return this.ordenarDesafiosPorNivelDeCoincidencia(desafiosSeleccionados, usuario);
	}

}

package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Usuario;

public class PreferenciasEnJuego implements RecomendacionDeDesafio {

	@Override
	public List<Desafio> seleccionDeDesafios(Usuario usuario) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		seleccion = desafiosDeTodosLosProyectosDelUsuario(usuario);
		seleccion = ordenarDesafiosPorNivelDeCoincidencia(seleccion, usuario);
		
		return seleccion.stream().limit(5).toList();
	}

	private List<Desafio> desafiosDeTodosLosProyectosDelUsuario(Usuario usuario) {
		List<Desafio> desafiosDeProyectos = new ArrayList<Desafio>();
		usuario.
		getProyectosActivos().
		stream().
		forEach(p -> desafiosDeProyectos.addAll(p.getDesafios())); 
		return desafiosDeProyectos;
	}
	
	public List<Desafio> ordenarDesafiosPorNivelDeCoincidencia(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		desafiosOrdenados = desafios
	            .stream()
	            .sorted((d1,d2) -> Integer.compare(d1.coincidenciasConLasPreferenciasDeUnUsuario(usuario), d2.coincidenciasConLasPreferenciasDeUnUsuario(usuario)))
	            .collect(Collectors.toList());
		return desafiosOrdenados;
	}
	
	
	
}

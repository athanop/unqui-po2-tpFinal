package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Preferencia;
import ar.edu.unq.po2.Proyecto;
import ar.edu.unq.po2.Usuario;

public class Favoritos implements RecomendacionDeDesafio{
	
	
	@Override
	public List<Desafio> seleccionDeDesafios(Usuario usuario) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		seleccion = desafiosDeTodosLosProyectosDelUsuario(usuario);
		seleccion = ordenarDesafiosPorSimilitud(seleccion, usuario);
		return seleccion.stream().limit(5).toList();
	}


	private List<Desafio> filtrarDesafiosQueYaContieneElUsuario(Usuario usuario) {
		List<Desafio> desafiosFiltrados = new ArrayList<Desafio>();
		desafiosFiltrados = usuario.getDesafiosUsuario().stream().map(d -> d.getDesafio()).toList();
		return desafiosFiltrados;
		}

	
	public List<Desafio> ordenarDesafiosPorSimilitud(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		return desafiosOrdenados;
	}
	
	public List<Desafio> desafiosPorNivelDeCoincidencia(Usuario usuario) {
		List<Desafio> desafios = new ArrayList<Desafio>();
		desafios = desafiosDeTodosLosProyectosDelUsuario(usuario);
		desafios = desafios
	            .stream()
	            .sorted((d1,d2) -> Integer.compare(this.coincidenciasConLasPreferenciasDeUnUsuario(d1, usuario), this.coincidenciasConLasPreferenciasDeUnUsuario(d2, usuario)))
	            .collect(Collectors.toList());
		return desafios.stream().limit(20).toList();
	}
	
	
	private List<Desafio> desafiosDeTodosLosProyectosDelUsuario(Usuario usuario) {
		List<Desafio> desafiosDeProyectos = new ArrayList<Desafio>();
		usuario.
		getProyectosActivos().
		stream().
		forEach(p -> desafiosDeProyectos.addAll(p.getDesafios())); 
		return desafiosDeProyectos;
	}
	
	
	public Integer coincidenciasConLasPreferenciasDeUnUsuario(Desafio desafio, Usuario usuario) {
		Integer valorMuestras   = (Math.abs(usuario.getPreferencia().getCantidadDeMuestras() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(usuario.getPreferencia().getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(usuario.getPreferencia().getRecompensa() - desafio.getRecompensa()));
		return (valorMuestras + valorDificultad + valorRecompensa) / 3;
	}

	
	
	
	

}

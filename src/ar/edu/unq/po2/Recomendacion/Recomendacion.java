package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Sistema;
import ar.edu.unq.po2.Usuario;

public abstract class Recomendacion {
	
	
	public abstract List<Desafio> seleccionDeDesafios(Sistema sistema, Usuario usuario);
	
	public abstract List<Desafio> ordenarDesafios(Usuario usuario, List<Desafio> desafiosSeleccionados);
	

	public List<Desafio> ordenarDesafiosPorNivelDeCoincidencia(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		desafiosOrdenados = desafios
	            .stream()
	            .sorted((d1,d2) -> Integer.compare(this.coincidenciasConLasPreferenciasDeUnUsuario(d1, usuario), this.coincidenciasConLasPreferenciasDeUnUsuario(d2, usuario)))
	            .collect(Collectors.toList());
		return desafiosOrdenados;
	}
	
	public List<Desafio> filtrarYRemoverDesafiosQueYaConoceElUsuario(Sistema sistema, Usuario usuario, List<Desafio> desafios){
		List<Desafio> desafiosFiltrados = new ArrayList<Desafio>();
		desafiosFiltrados = this.desafiosDeTodosLosProyectosDelSistema(sistema, usuario);
		desafiosFiltrados = this.removerDesafiosQueYaContieneElUsuario(usuario, desafiosFiltrados);
		return desafiosFiltrados;
	}
	
	private List<Desafio> removerDesafiosQueYaContieneElUsuario(Usuario usuario, List<Desafio> seleccion) {
		List<Desafio> desafiosSeleccionados = new ArrayList<Desafio>();
		desafiosSeleccionados = seleccion;
		desafiosSeleccionados.removeAll(filtrarDesafiosQueYaContieneElUsuario(usuario));
		return desafiosSeleccionados;
		
	}

	private List<Desafio> filtrarDesafiosQueYaContieneElUsuario(Usuario usuario) {
		List<Desafio> desafiosFiltrados = new ArrayList<Desafio>();
		desafiosFiltrados = usuario.getDesafiosUsuario().stream().map(d -> d.getDesafio()).toList();
		return desafiosFiltrados;
		}

	private List<Desafio> desafiosDeTodosLosProyectosDelSistema(Sistema sistema, Usuario usuario) {
		List<Desafio> desafiosDeProyectos = new ArrayList<Desafio>();
		sistema.
		getProyectosDeUsuario(usuario).
		stream().
		forEach(p -> desafiosDeProyectos.addAll(p.getDesafios())); 
		return desafiosDeProyectos;
	}
	
	
	private Integer coincidenciasConLasPreferenciasDeUnUsuario(Desafio desafio, Usuario usuario) {
		Integer valorMuestras   = (Math.abs(usuario.getPreferencia().getCantidadDeMuestras() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(usuario.getPreferencia().getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(usuario.getPreferencia().getRecompensa() - desafio.getRecompensa()));
		return valorMuestras + valorDificultad + valorRecompensa;
	}
	
	
	
}

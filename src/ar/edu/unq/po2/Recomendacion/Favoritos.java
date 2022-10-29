package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Usuario;

public class Favoritos implements RecomendacionDeDesafio{
	
	
	@Override
	public List<Desafio> seleccionDeDesafios(Usuario usuario) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		seleccion = desafiosDeTodosLosProyectosDelUsuario(usuario);
		seleccion = removerDesafiosQueYaContieneElUsuario(usuario, seleccion);
		seleccion = ordenarDesafiosPorSimilitud(seleccion, this.desafioFavoritoDelUsuario(usuario));
		return seleccion.stream().limit(5).toList();
	}
	
	public List<Desafio> ordenarDesafiosPorSimilitud(List<Desafio> desafios, Desafio favorito) {
		List<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		desafiosOrdenados = 
				desafios
	            .stream()
	            .sorted((d1,d2) -> this.similitudEntreDesafios(d1, favorito).compareTo(this.similitudEntreDesafios(d2, favorito)))
	            .collect(Collectors.toList());
		return desafiosOrdenados.stream().limit(20).toList();
	}
	
	//hasta acá creo q va bien
	public Integer similitudEntreDesafios(Desafio favorito, Desafio desafio) {
		Integer valorMuestras   = (Math.abs(favorito.getMuestrasRecolectadas() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(favorito.getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(favorito.getRecompensa() - desafio.getRecompensa()));
		return (valorMuestras + valorDificultad + valorRecompensa) / 3;
	}
	
	public Desafio desafioFavoritoDelUsuario(Usuario usuario) {
		return usuario
				.getDesafiosUsuario()
				.stream()
				.max((d1, d2) -> d1.getValoracion().compareTo(d2.getValoracion())).get().getDesafio();
	}
	
	
	//los 20 desafios con mayor coincidencia
	public List<Desafio> ordenarDesafiosPorNivelDeCoincidencia(List<Desafio> desafios, Usuario usuario) {
		List<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		desafiosOrdenados = desafios
	            .stream()
	            .sorted((d1,d2) -> Integer.compare(this.coincidenciasConLasPreferenciasDeUnUsuario(d1, usuario), this.coincidenciasConLasPreferenciasDeUnUsuario(d2, usuario)))
	            .collect(Collectors.toList());
		return desafiosOrdenados.stream().limit(20).toList();
	}
	
	
	public Integer coincidenciasConLasPreferenciasDeUnUsuario(Desafio desafio, Usuario usuario) {
		Integer valorMuestras   = (Math.abs(usuario.getPreferencia().getCantidadDeMuestras() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(usuario.getPreferencia().getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(usuario.getPreferencia().getRecompensa() - desafio.getRecompensa()));
		return valorMuestras + valorDificultad + valorRecompensa;
	}

	
	public List<Desafio> removerDesafiosQueYaContieneElUsuario(Usuario usuario, List<Desafio> seleccion) {
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
	
	private List<Desafio> desafiosDeTodosLosProyectosDelUsuario(Usuario usuario) {
		List<Desafio> desafiosDeProyectos = new ArrayList<Desafio>();
		usuario.
		getProyectosActivos().
		stream().
		forEach(p -> desafiosDeProyectos.addAll(p.getDesafios())); 
		return desafiosDeProyectos;
	}

	
	

}

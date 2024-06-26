package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Sistema;
import ar.edu.unq.po2.Usuario;

public class Favoritos extends Recomendacion {

	@Override
	public List<Desafio> seleccionDeDesafios(Sistema sistema, Usuario usuario) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		seleccion = this.filtrarYRemoverDesafiosQueYaConoceElUsuario(sistema, usuario, seleccion);
		seleccion = this.ordenarDesafios(usuario, seleccion);
		return seleccion.stream().limit(5).toList();
	}

	@Override
	public List<Desafio> ordenarDesafios(Usuario usuario, List<Desafio> desafiosSeleccionados) {
		return ordenarVeinteDesafiosPorSimilitudConElDesafioFavoritoDelUsuario(usuario, desafiosSeleccionados);
	}
	
	
	private List<Desafio> ordenarVeinteDesafiosPorSimilitudConElDesafioFavoritoDelUsuario(Usuario usuario,
			List<Desafio> seleccion) {
		return ordenarDesafiosPorSimilitud(veinteDesafiosPorNivelDeCoincidencia(seleccion, usuario),
				this.desafioFavoritoDelUsuario(usuario));
	}

	private List<Desafio> ordenarDesafiosPorSimilitud(List<Desafio> desafios, Desafio favorito) {
		List<Desafio> desafiosOrdenados = new ArrayList<Desafio>();
		desafiosOrdenados = desafios.stream().sorted((d1, d2) -> this.similitudEntreDesafios(d1, favorito)
				.compareTo(this.similitudEntreDesafios(d2, favorito))).collect(Collectors.toList());
		return desafiosOrdenados.stream().toList();
	}

	private List<Desafio> veinteDesafiosPorNivelDeCoincidencia(List<Desafio> desafios, Usuario usuario) {
		return this.ordenarDesafiosPorNivelDeCoincidencia(desafios, usuario).stream().limit(20).toList();
	}

	private Integer similitudEntreDesafios(Desafio favorito, Desafio desafio) {
		Integer valorMuestras = (Math.abs(favorito.getMuestrasRecolectadas() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(favorito.getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(favorito.getRecompensa() - desafio.getRecompensa()));
		return (valorMuestras + valorDificultad + valorRecompensa) / 3;
	}

	private Desafio desafioFavoritoDelUsuario(Usuario usuario) {
		return usuario.getDesafiosUsuario().stream().max((d1, d2) -> d1.getValoracion().compareTo(d2.getValoracion()))
				.get().getDesafio();
	}



}

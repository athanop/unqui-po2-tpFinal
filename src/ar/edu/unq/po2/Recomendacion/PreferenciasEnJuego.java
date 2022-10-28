package ar.edu.unq.po2.Recomendacion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Preferencia;
import ar.edu.unq.po2.Proyecto;

public class PreferenciasEnJuego implements RecomendacionDeDesafio {

	@Override
	public List<Desafio> seleccionDeDesafios(Preferencia preferencia, List<Proyecto> proyectos) {
		List<Desafio> seleccion = new ArrayList<Desafio>();
		for(Proyecto proyecto:proyectos) {
			seleccion = this.vincularDesafioConNivelDeCoincidencia(preferencia, proyecto.getDesafios()).keySet().stream().limit(5).collect(Collectors.toList());	
		}
		return seleccion;
	}
		
	public Integer calcularCoincidencia(Preferencia preferencia, Desafio desafio) {
		Integer valorMuestras   = (Math.abs(preferencia.getCantidadDeMuestras() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(preferencia.getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(preferencia.getRecompensa() - desafio.getRecompensa()));
		return valorMuestras + valorDificultad + valorRecompensa;
	}
	

	public Map<Desafio, Integer> vincularDesafioConNivelDeCoincidencia(Preferencia preferencia, List<Desafio> desafios){
		Map<Desafio, Integer> seleccion = new LinkedHashMap<Desafio, Integer>(); //uso linkedhashmap porque mantiene el orden de insercion
		for(Desafio des:desafios) {
			seleccion.put(des, this.calcularCoincidencia(preferencia, des));
		}
		return desafioOrdenadoPorNivelDeCoincidencia(seleccion);
	}

	private LinkedHashMap<Desafio, Integer> desafioOrdenadoPorNivelDeCoincidencia(Map<Desafio, Integer> desafios) {
		return desafios.entrySet()
	            .stream()
	            .sorted((d1,d2) -> Integer.compare(d1.getValue(), d2.getValue()))
	            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (d1, d2) -> d1, LinkedHashMap::new));
	}

}

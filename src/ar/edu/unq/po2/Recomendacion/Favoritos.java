package ar.edu.unq.po2.Recomendacion;

import java.util.List;

import ar.edu.unq.po2.Desafio;
import ar.edu.unq.po2.Preferencia;
import ar.edu.unq.po2.Proyecto;

public class Favoritos implements RecomendacionDeDesafio{

	@Override
	public List<Desafio> seleccionDeDesafios(Preferencia preferencia, Proyecto proyecto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer calcularCoincidencia(Preferencia preferencia, Desafio desafio) {
		Integer valorMuestras   = (Math.abs(preferencia.getCantidadDeMuestras() - desafio.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(preferencia.getDificultad() - desafio.getDificultad()));
		Integer valorRecompensa = (Math.abs(preferencia.getRecompensa() - desafio.getRecompensa()));
		return (valorMuestras + valorDificultad + valorRecompensa) / 3;
	}
	
	
	
	

}

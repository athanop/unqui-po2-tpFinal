package ar.edu.unq.po2;

import ar.edu.unq.po2.RestriccionTemporal.RestriccionTemporal;

public class Desafio {

	private Integer dificultad;
	private Integer muestrasRecolectadas;
	private Integer recompensa;
	private RestriccionTemporal restriccion;

	public Integer getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	public void setMuestrasRecolectadas(Integer muestrasRecolectadas) {
		this.muestrasRecolectadas = muestrasRecolectadas;
	}

	public Integer getDificultad() {
		return dificultad;
	}

	public Integer getRecompensa() {
		return recompensa;
	}

	public RestriccionTemporal getRestriccion() {
		return restriccion;
	}
	
	public Desafio(Integer muestrasRecolectadas, Integer dificultad, Integer recompensa, RestriccionTemporal restriccion) {
		this.dificultad = dificultad;
		this.muestrasRecolectadas = muestrasRecolectadas;
		this.recompensa = recompensa;
		this.restriccion = restriccion;
	}
	
	public Integer coincidenciasConLasPreferenciasDeUnUsuario(Usuario usuario) {
		Integer valorMuestras   = (Math.abs(usuario.getPreferencia().getCantidadDeMuestras() - this.getMuestrasRecolectadas()));
		Integer valorDificultad = (Math.abs(usuario.getPreferencia().getDificultad() - this.getDificultad()));
		Integer valorRecompensa = (Math.abs(usuario.getPreferencia().getRecompensa() - this.getRecompensa()));
		return valorMuestras + valorDificultad + valorRecompensa;
	}

}

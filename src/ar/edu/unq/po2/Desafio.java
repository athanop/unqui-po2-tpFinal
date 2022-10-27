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

}

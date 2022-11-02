package ar.edu.unq.po2;

import ar.edu.unq.po2.Area.Area;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionTemporal;

public class Desafio {

	private Integer dificultad;
	private Integer muestrasRecolectadas;
	private Integer recompensa;
	private RestriccionTemporal restriccion;
	private Area area;

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
	
	public Area getArea() {
		return area;
	}

	public Desafio(Integer muestrasRecolectadas, Integer dificultad, Integer recompensa, RestriccionTemporal restriccion, Area area) {
		this.dificultad = dificultad;
		this.muestrasRecolectadas = muestrasRecolectadas;
		this.recompensa = recompensa;
		this.restriccion = restriccion;
		this.area = area;
	}

	public boolean muestraDentroDeAreaYFecha(Muestra muestra) {
		return this.getRestriccion().esFechaPermitida(muestra.getFechaYHora()) && this.getArea().coordenadaEstaDentroDelArea(muestra.getCoordenada());
	}
}

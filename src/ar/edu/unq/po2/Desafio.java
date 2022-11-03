package ar.edu.unq.po2;

import ar.edu.unq.po2.Area.Area;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionTemporal;

/**
 * Clase que representa un Desafio.
 */
public class Desafio {

	private Integer dificultad;
	private Integer muestrasRecolectadas;
	private Integer recompensa;
	private RestriccionTemporal restriccion;
	private Area area;

	/**
	 * Describe la cantidad de muestras que se necesitan para completar el desafio.
	 * @return la cantidad de muestras como numero.
	 */
	public Integer getMuestrasRecolectadas() {
		return muestrasRecolectadas;
	}

	/**
	 * Establece la cantidad de muestras que se necesitan para completar el desafio.
	 * @param muestrasRecolectadas, es la cantidad de muestras necesarias para completar el desafio.
	 */
	public void setMuestrasRecolectadas(Integer muestrasRecolectadas) {
		this.muestrasRecolectadas = muestrasRecolectadas;
	}

	/**
	 * Describe un numero entre 1 y 5, donde 1 es muy facil y 5 es muy dificil.
	 * @return la dificultad como numero.
	 */
	public Integer getDificultad() {
		return dificultad;
	}

	/**
	 * Describe un numero que indica el puntaje obtenido como recompensa.
	 * @return la recompensa como numero.
	 */
	public Integer getRecompensa() {
		return recompensa;
	}

	/**
	 * Describe momentos en donde es valido el envio de las muestras.
	 * @return las restricciones temporales.
	 */
	public RestriccionTemporal getRestriccion() {
		return restriccion;
	}
	
	/**
	 * Describe el area geografica donde deben efectuarse las muestras.
	 * @return el area geografica.
	 */
	public Area getArea() {
		return area;
	}
	/**
	 * Constructor de un Desafio.
	 * @param muestrasRecolectadas: cantidad de muestras que se necesitan para completar el desafio.
	 * @param dificultad: un numero entre 1 y 5, donde 1 es muy facil y 5 es muy dificil.
	 * @param recompensa: un numero que indica el puntaje obtenido como recompensa.
	 * @param restriccion: momentos en donde es valido el envio de las muestras.
	 * @param area: el area geografica donde deben efectuarse las muestras.
	 */
	public Desafio(Integer muestrasRecolectadas, Integer dificultad, Integer recompensa, RestriccionTemporal restriccion, Area area) {
		this.dificultad = dificultad;
		this.muestrasRecolectadas = muestrasRecolectadas;
		this.recompensa = recompensa;
		this.restriccion = restriccion;
		this.area = area;
	}

	/**
	 * Indica si la muestra dada se encuentra dentro de la fecha y area permitidas por el desafio.
	 * @param muestra representa a una Muestra
	 * @return True si la muestra cumple con la restriccion temporal y el area correspondiente al desafio
	 */
	public boolean muestraDentroDeAreaYFecha(Muestra muestra) { // Falta validar fecha desde cuando se puede enviar muestra
		return this.getRestriccion().esFechaPermitida(muestra.getFechaYHora()) && this.getArea().coordenadaEstaDentroDelArea(muestra.getCoordenada());
	}
}

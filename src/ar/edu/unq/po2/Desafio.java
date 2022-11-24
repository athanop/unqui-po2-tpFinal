package ar.edu.unq.po2;

import java.time.LocalDate;

import ar.edu.unq.po2.Area.Area;
import ar.edu.unq.po2.Area.Coordenada;
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
	 * Indica si la fecha dada se encuentra dentro de la fecha de restriccion temporal permitida.
	 * @param fecha representa a una LocalDate.
	 * @return True si la fecha cumple con la restriccion temporal correspondiente al desafio.
	 */
	public boolean fechaCumpleRestriccionTemporal(LocalDate fecha) {
		return this.getRestriccion().esFechaPermitida(fecha);
	}
	
	/**
	 * Indica si la coordenada dada se encuentra dentro del area permitida por el desafio.
	 * @param coord representa a una Coordenada
	 * @return True si la coord cumple con el area correspondiente al desafio.
	 */
	public boolean coordenadaCumpleAreaDesafio(Coordenada coord) {
		return this.getArea().coordenadaEstaDentroDelArea(coord);
	}
}

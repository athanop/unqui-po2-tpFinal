package ar.edu.unq.po2;

/**
 * Clase encargada de representar una Preferencia para la busqueda de desafios.
 */
public class Preferencia {

	private Integer dificultad;
	private Integer recompensa;
	private Integer cantidadDeMuestras;

	/**
	 * Getter dificultad
	 * 
	 * @return Devuelve la dificultad de la preferencia.
	 */
	public Integer getDificultad() {
		return dificultad;
	}

	/**
	 * Getter recompensa
	 * 
	 * @return Devuelve la recompensa de la preferencia.
	 */
	public Integer getRecompensa() {
		return recompensa;
	}

	/**
	 * Getter cantidad de muestras
	 * 
	 * @return Devuelve la cantidad de muestras necesarias para la preferencia.
	 */
	public Integer getCantidadDeMuestras() {
		return cantidadDeMuestras;
	}

	/**
	 * Constructor de preferencia.
	 * 
	 * @param dificultad    		un numero que representa la dificultad del desafio.
	 * @param recompensa 			un numero que representa la recompensa obtenida en el desafio.
	 * @param cantidadDeMuestras 	un numero de muestras necesarias para completar el desafio.
	 */
	public Preferencia(Integer dificultad, Integer recompensa, Integer cantidadDeMuestras) {
		super();
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.cantidadDeMuestras = cantidadDeMuestras;
	}

}

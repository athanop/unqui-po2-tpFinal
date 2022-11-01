package ar.edu.unq.po2;

import java.time.LocalDate;

import ar.edu.unq.po2.Area.Coordenada;

/**
 * Clase encargada de representar una muestra tomada por un usuario.
 */
public class Muestra {

	private Usuario usuario;
	private Coordenada coordenada;
	private LocalDate fechaYHora;

	/**
	 * Constructor de muestra
	 * 
	 * @param usuario    Usuario que envio la muestra.
	 * @param coordenada donde se tomo la muestra.
	 * @param fechaYHora momento cuando se envio la muestra.
	 */
	public Muestra(Usuario usuario, Coordenada coordenada, LocalDate fechaYHora) {
		super();
		this.usuario = usuario;
		this.coordenada = coordenada;
		this.fechaYHora = fechaYHora;
	}

	/**
	 * Getter coordenada
	 * 
	 * @return Devuelve la ubicacion de la muestra.
	 */
	public Coordenada getCoordenada() {
		return this.coordenada;
	}

	public LocalDate getFechaYHora() {
		return this.fechaYHora;
	}

}

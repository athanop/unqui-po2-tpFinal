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
	 * fechaYHora momento cuando se envio la muestra.
	 */
	public Muestra(Usuario usuario, Coordenada coordenada) {
		super();
		this.usuario = usuario;
		this.coordenada = coordenada;
		this.fechaYHora = LocalDate.now();
	}

	/**
	 * Getter coordenada
	 * 
	 * @return Devuelve la ubicacion de la muestra.
	 */
	public Coordenada getCoordenada() {
		return this.coordenada;
	}

	/**
	 * Getter fechaYHora
	 * 
	 * @return Devuelve la fecha y hora de cuando se realizo la muestra.
	 */
	public LocalDate getFechaYHora() {
		return this.fechaYHora;
	}
	
	/**
	 * Getter usuario
	 * 
	 * @return Devuelve el Usuario que realizo la muestra.
	 */
	public Usuario getUsuario() {
		return this.usuario;
	}
}

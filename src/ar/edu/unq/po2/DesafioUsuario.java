package ar.edu.unq.po2;

import java.time.LocalDate;

import ar.edu.unq.po2.EstadoDesafio.DesafioIncompleto;
import ar.edu.unq.po2.EstadoDesafio.EstadoDesafioUsuario;

/**
 * Clase que representa un Desafio aceptado por un Usuario.
 */
public class DesafioUsuario {

	private Desafio desafio;
	private Usuario usuario;
	private EstadoDesafioUsuario estado;
	private Integer valoracion;
	private LocalDate fechaCompletitud;

	/**
	 * Describe el estado del desafio aceptado por el usuario.
	 * @return el estado en el que se encuentra el desafio aceptado por el usuario.
	 */
	public EstadoDesafioUsuario getEstado() {
		return estado;
	}

    /**
     * Establece un cambio del estado del desafio aceptado por el usuario.
     * @param estado es el estado al que cambia el desafio aceptado por el usuario.
     */
	public void setEstado(EstadoDesafioUsuario estado) {
		this.estado = estado;
	}

	/**
	 * Describe el desafio aceptado por el usuario.
	 * @return el desafio aceptado por el usuario.
	 */
	public Desafio getDesafio() {
		return desafio;
	}

	/**
	 * Describe el usuario que acepto el desafio.
	 * @return el usuario.
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Describe la valoracion que le dio el usuario al desafio.
	 * @return la valoracion dada por el usuario.
	 */
	public Integer getValoracion() {
		return valoracion;
	}

    /**
     * Establece una valoracion del desafio aceptado por el usuario.
     * @param valoracion es la valoracion del desafio aceptado por el usuario
     */
	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}
	
	/**
	 * Describe la fecha cuando se completo el desafio.
	 * @return la fecha cuando el usuario completa el desafio.
	 */
	public LocalDate getFechaCompletitud() {
		return fechaCompletitud;
	}

	/**
	 * Constructor de un DesafioUsuario.
	 * @param desafio, el desafio aceptado.
	 * @param usuario, el usuario al que pertenece el desafio aceptado.
	 * @param valoracion, el usuario puede votar cuanto le gusto realizar este desafio indicando un valor entre 0 y 5, donde 0 significa que no le gusto nada y 5 que le gusto mucho
	 */
	public DesafioUsuario(Desafio desafio, Usuario usuario, Integer valoracion) {
		this.desafio = desafio;
		this.usuario = usuario;
		this.valoracion = valoracion;
		this.estado = new DesafioIncompleto();
		this.fechaCompletitud = null;
	}
	
	/**
	 * Realiza la votacion del usuario hacia el desafio que acepto.
	 * @param valoracion, el usuario puede votar cuanto le gusto realizar este desafio indicando un valor entre 0 y 5, donde 0 significa que no le gusto nada y 5 que le gusto mucho
	 */
	public void votoDelUsuario(Integer valoracion) throws Exception {
		if (estado.esDesafioCompleto(desafio, usuario) && valoracion <= 5) {
			this.setValoracion(valoracion);
		} else {
			throw new Exception("la valoracion debe ser de 0 a 5");
		}
	}

	/**
	 * Actualiza el estado del desafio aceptado por el usuario.
	 */
	public void actualizarDesafio() throws Exception{
		this.estado.actualizarDesafio(this);
	}
	
	/**
	 * Indica la fecha en donde el desafio es batido por el usuario cuando cambia de estado incompleto a completo.
	 * @param fecha, la fecha cuando se completo el desafio. 
	 */
	public void setFechaCompletitud(LocalDate fecha) {
		this.fechaCompletitud = fecha;
	}
	
}

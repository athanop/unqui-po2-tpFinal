package ar.edu.unq.po2.EstadoDesafio;

import ar.edu.unq.po2.DesafioUsuario;
import ar.edu.unq.po2.Usuario;

/**
 * Interfaz que implementan los diferentes estados de un Desafio aceptado por un Usuario.
 */
public interface EstadoDesafioUsuario {

	/**
	 * Indica si el Desafio ya esta completo por el Usuario.	
	 * @param desafio, es el desafio que debe ser completado.
	 * @param usuario, es el usuario que debe completar el desafio.
	 * @return True si el Desafio esta completo por el Usuario
	 */
	public Boolean esDesafioCompleto(DesafioUsuario desafio, Usuario usuario);

	/**
	 * Describe el porcentaje de completitud del Desafio aceptado por el Usuario.	
	 * @param desafio, es el desafio que debe ser completado.
	 * @param usuario, es el usuario que debe completar el desafio.
	 * @return un numero entero que indica el porcentaje de completitud.
	 */
	public Integer porcentajeDeCompletitud(DesafioUsuario desafio, Usuario usuario);

	/**
	 * Actualiza el estado del Desafio aceptado por el Usuario.	
	 * @param desafio, es el desafio que debe ser completado.
	 * @param usuario, es el usuario que debe completar el desafio.
	 */
	public void actualizarDesafio(DesafioUsuario desafio, Usuario usuario) throws Exception;
	
	public void setearValoracion(DesafioUsuario desafioUsuario, Integer valoracion) throws Exception;
	
}

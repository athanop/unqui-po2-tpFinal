package ar.edu.unq.po2;

import java.time.LocalDate;

import ar.edu.unq.po2.EstadoDesafio.DesafioIncompleto;
import ar.edu.unq.po2.EstadoDesafio.EstadoDesafioUsuario;

/**
 * Clase que representa un Desafio aceptado por un Usuario.
 */
public class DesafioUsuario {

	private Desafio desafio;
	private EstadoDesafioUsuario estado;
	private Integer valoracion;
	private LocalDate fechaAceptacion;
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
	 * Describe la fecha cuando se acepta el desafio.
	 * @return la fecha cuando el usuario acepta el desafio.
	 */
	public LocalDate getFechaAceptacion() {
		return fechaAceptacion;
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
	public DesafioUsuario(Desafio desafio, Integer valoracion, LocalDate fechaCompletitud) {
		this.desafio = desafio;
		this.valoracion = valoracion;
		this.estado = new DesafioIncompleto();
		this.fechaAceptacion = LocalDate.now();
		this.fechaCompletitud = fechaCompletitud;
	}
	
	/**
	 * Realiza la votacion del usuario hacia el desafio que acepto.
	 * @param valoracion, el usuario puede votar cuanto le gusto realizar este desafio indicando un valor entre 0 y 5, donde 0 significa que no le gusto nada y 5 que le gusto mucho
	 */
	public void votoDelUsuario(Integer valoracion) throws Exception {
		estado.setearValoracion(this, valoracion);
	}

	/**
	 * Actualiza el estado del desafio aceptado por el usuario.
	 */
	public void actualizarDesafio(Usuario usuario) throws Exception {
		this.estado.actualizarDesafio(this, usuario);
	}
	
	/**
	 * Indica la fecha en donde el desafio es batido por el usuario cuando cambia de estado incompleto a completo.
	 * @param fecha, la fecha cuando se completo el desafio. 
	 */
	public void setFechaCompletitud(LocalDate fecha) {
		this.fechaCompletitud = fecha;
	}
	

	/**
	 * Indica si la muestra dada se encuentra dentro de la fecha y area permitidas por el desafio y fue enviada luego de aceptar el desafio.
	 * @param muestra representa a una Muestra
	 * @return True si la muestra cumple con la fecha de aceptacion, la restriccion temporal y el area correspondiente al desafio.
	 */
	public boolean muestraDentroDeAreaYFecha(Muestra muestra) {
		return this.muestraDentroDeFecha(muestra) && this.muestraDentroDeRestriccionTemporal(muestra) && this.muestraDentroDeArea(muestra);
	}
	
	/**
	 * Indica si la muestra dada es posterior a la fecha de aceptacion del desafio.
	 * @param muestra representa a una Muestra
	 * @return True si la muestra cumple con la fecha de aceptacion correspondiente al desafio.
	 */
	public boolean muestraDentroDeFecha(Muestra muestra) {
		return muestra.getFechaYHora().isAfter(this.getFechaAceptacion());
	}
	
	/**
	 * Indica si la muestra dada se encuentra dentro de la fecha de restriccion temporal permitida.
	 * @param muestra representa a una Muestra
	 * @return True si la muestra cumple con la restriccion temporal correspondiente al desafio.
	 */
	public boolean muestraDentroDeRestriccionTemporal(Muestra muestra) {
		return this.getDesafio().fechaCumpleRestriccionTemporal(muestra.getFechaYHora());
	}
	
	/**
	 * Indica si la muestra dada se encuentra dentro del area permitida por el desafio.
	 * @param muestra representa a una Muestra
	 * @return True si la muestra cumple con el area correspondiente al desafio.
	 */
	public boolean muestraDentroDeArea(Muestra muestra) {
		return this.getDesafio().coordenadaCumpleAreaDesafio(muestra.getCoordenada());
	}
	
	/**
	 * Devuelve la cantidad de muestras de un Usuario que se encuentran dentro de la fecha y area permitidas por el desafio y fue enviada luego de aceptar el desafio.
	 * @param usuario representa un Usuario.
	 * @return un numero entero, la cantidad de muestras validas.
	 */
	public Integer cantidadDeMuestrasValidas(Usuario usuario) {
		return usuario.getMuestrasRecolectadas().stream().filter(m -> this.muestraDentroDeAreaYFecha(m)).toList().size();
	}
	
	/**
	 * Devuelve el porcentaje de completitud que tiene un Usuario sobre el desafio.
	 * @param usuario representa un Usuario.
	 * @return un numero entero, el porcentaje de completitud.
	 */
	public Integer porcentajeDeCompletitud(Usuario usuario) {
		return this.getEstado().porcentajeDeCompletitud(this, usuario);
	}
}

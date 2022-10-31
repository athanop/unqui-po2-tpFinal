package ar.edu.unq.po2.RestriccionTemporal;

import java.time.LocalDate;
/**
 * Interfaz que modela la reestriccion temporal de envio de muestras para desafios con distintos filtros de fecha con un patron Composite.
 * 
 * @author ivanapr
 *
 */
public interface RestriccionTemporal {
	public boolean esFechaPermitida(LocalDate fecha);
	public void agregarRestriccion(RestriccionTemporal restriccion);
	public void eliminarRestriccion(RestriccionTemporal restriccion);
}

package ar.edu.unq.po2.RestriccionTemporal;

import java.time.LocalDate;
/**
 * Interfaz que modela la restriccion temporal de envio de muestras para desafios con distintos filtros de fecha con un patron Composite.
 * 
 * @author ivanapr
 *
 */
public interface RestriccionTemporal {
	public boolean esFechaPermitida(LocalDate fecha);
}

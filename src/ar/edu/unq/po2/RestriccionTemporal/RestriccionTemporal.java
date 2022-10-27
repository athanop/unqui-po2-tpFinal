package ar.edu.unq.po2.RestriccionTemporal;

import ar.edu.unq.po2.Muestra;

/**
 * Interfaz que modela la reestriccion temporal de envio de muestras para desafios con distintos filtros de fecha con un patron Composite.
 * 
 * @author ivanapr
 *
 */
public interface RestriccionTemporal {
	public void validar(Muestra muestra);
}

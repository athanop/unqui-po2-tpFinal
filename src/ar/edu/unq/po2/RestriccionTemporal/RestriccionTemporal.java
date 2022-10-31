package ar.edu.unq.po2.RestriccionTemporal;

import ar.edu.unq.po2.Muestra;
import java.time.LocalDate;
import java.util.List;
/**
 * Interfaz que modela la reestriccion temporal de envio de muestras para desafios con distintos filtros de fecha con un patron Composite.
 * 
 * @author ivanapr
 *
 */
public interface RestriccionTemporal {
	public void validar(Muestra muestra);
	public void agregarRestriccion(RestriccionTemporal restriccion);
	public void eliminarRestriccion(RestriccionTemporal restriccion);
}

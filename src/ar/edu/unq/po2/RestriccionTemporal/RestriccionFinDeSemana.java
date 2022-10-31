package ar.edu.unq.po2.RestriccionTemporal;

import java.time.LocalDate;

/**
 * Clase que modela la restriccion temporal de los dias de fines de semana con el patron Composite.
 *
 */
public class RestriccionFinDeSemana implements RestriccionTemporal {

	@Override
	public boolean esFechaPermitida(LocalDate fecha) {
		return fecha.getDayOfWeek().getValue() > 5;
	}

	@Override
	public void agregarRestriccion(RestriccionTemporal restriccion) {
	}

	@Override
	public void eliminarRestriccion(RestriccionTemporal restriccion) {
	}

}

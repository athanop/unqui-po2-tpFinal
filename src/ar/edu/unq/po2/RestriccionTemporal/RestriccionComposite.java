package ar.edu.unq.po2.RestriccionTemporal;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase que modela la restriccion temporal compuesta con el patron Composite.
 *
 */

public class RestriccionComposite implements RestriccionTemporal {

	private List<RestriccionTemporal> restricciones;

	public RestriccionComposite(List<RestriccionTemporal> restricciones) {
		this.setRestricciones(restricciones);
	}

	public List<RestriccionTemporal> getRestricciones() {
		return this.restricciones;
	}

	public void setRestricciones(List<RestriccionTemporal> restricciones) {
		this.restricciones = restricciones;
	}
	
	@Override
	public boolean esFechaPermitida(LocalDate fecha) {
		return this.getRestricciones().stream().allMatch(restriccion -> restriccion.esFechaPermitida(fecha));
	}
	
	public void agregarRestriccion(RestriccionTemporal restriccion) {
		this.restricciones.add(restriccion);
	}

	public void eliminarRestriccion(RestriccionTemporal restriccion) {
		this.restricciones.remove(restriccion);
	}

}

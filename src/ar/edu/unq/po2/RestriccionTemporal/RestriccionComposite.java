package ar.edu.unq.po2.RestriccionTemporal;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.Muestra;

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
	public void validar(Muestra muestra) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void agregarRestriccion(RestriccionTemporal restriccion) {
		this.getRestricciones().add(restriccion);
	}

	@Override
	public void eliminarRestriccion(RestriccionTemporal restriccion) {
		this.getRestricciones().remove(restriccion);
	}

}

package ar.edu.unq.po2.RestriccionTemporal;

import java.time.LocalDate;

/**
 * Clase que modela la restriccion temporal de un intervalo de fechas con el patron Composite.
 *
 */

public class RestriccionFecha implements RestriccionTemporal {
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	
	public RestriccionFecha(LocalDate fechainicio,LocalDate fechafinal) {
		this.fechaInicio = fechainicio;
		this.fechaFinal = fechafinal;
	}
	private LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	private LocalDate getFechaFinal() {
		return this.fechaFinal;
	}

	@Override
	public boolean esFechaPermitida(LocalDate fecha) {
		return ((fecha.isAfter(this.getFechaInicio())) && (fecha.isBefore(this.getFechaFinal())));
	}

}

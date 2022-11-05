package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.RestriccionTemporal.RestriccionFinDeSemana;

class RestriccionFinDeSemanaTestCase {

private RestriccionFinDeSemana finDeSemana;
	
	@BeforeEach
	void setUp() throws Exception {
		finDeSemana = new RestriccionFinDeSemana();
	}
	
	@Test
	void testEsFechaPermitidaFalse() {
		assertTrue(finDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 05))); // Sabado
		assertTrue(finDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 06))); // Domingo
	}
	
	@Test
	void testEsFechaPermitidaTrue() {
		assertFalse(finDeSemana.esFechaPermitida(LocalDate.of(2022, 10, 31))); // Lunes
		assertFalse(finDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 01))); // Martes
		assertFalse(finDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 02))); // Miercoles
		assertFalse(finDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 03))); // Jueves
		assertFalse(finDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 04))); // Viernes
	}


}

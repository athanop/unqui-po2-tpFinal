package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.RestriccionTemporal.RestriccionDiasDeSemana;

class RestriccionDiasDeSemanaTestCase {

	private RestriccionDiasDeSemana diasDeSemana;
	
	@BeforeEach
	void setUp() throws Exception {
		diasDeSemana = new RestriccionDiasDeSemana();
	}
	
	@Test
	void testEsFechaPermitidaTrue() {
		assertTrue(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 10, 31))); // Lunes
		assertTrue(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 01))); // Martes
		assertTrue(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 02))); // Miercoles
		assertTrue(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 03))); // Jueves
		assertTrue(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 04))); // Viernes
	}
	
	@Test
	void testEsFechaPermitidaFalse() {
		assertFalse(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 05))); // Sabado
		assertFalse(diasDeSemana.esFechaPermitida(LocalDate.of(2022, 11, 06))); // Domingo
	}
}

package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.RestriccionTemporal.RestriccionFecha;

class RestriccionFechaTestCase {

	private RestriccionFecha restriccionEntreFechas;
	
	@BeforeEach
	void setUp() throws Exception {
		restriccionEntreFechas = new RestriccionFecha(LocalDate.of(2022, 10, 20), LocalDate.of(2022, 11, 01));
	}
	@Test
	void testEsFechaPermitidaTrue() {
		assertTrue(restriccionEntreFechas.esFechaPermitida(LocalDate.of(2022, 10, 20)));
		assertTrue(restriccionEntreFechas.esFechaPermitida(LocalDate.of(2022, 10, 30)));
		assertTrue(restriccionEntreFechas.esFechaPermitida(LocalDate.of(2022, 11, 01)));
	}
	@Test
	void testEsFechaPermitidaFalse() {
		assertFalse(restriccionEntreFechas.esFechaPermitida(LocalDate.of(2022, 10, 19)));
		assertFalse(restriccionEntreFechas.esFechaPermitida(LocalDate.of(2022, 11, 02)));
	}
}

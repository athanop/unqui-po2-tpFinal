package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.RestriccionTemporal.RestriccionComposite;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionDiasDeSemana;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionFecha;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionFinDeSemana;
import ar.edu.unq.po2.RestriccionTemporal.RestriccionTemporal;

class RestriccionCompositeTestCase {
	
	private RestriccionComposite resc;
	private RestriccionFecha resf;
	private RestriccionFinDeSemana resfds;
	private RestriccionDiasDeSemana resdds;
	private List<RestriccionTemporal> rest = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		resf = new RestriccionFecha(LocalDate.of(2022, Month.OCTOBER, 20),LocalDate.of(2022, Month.NOVEMBER, 1));
		resfds = new RestriccionFinDeSemana();
		resdds = new RestriccionDiasDeSemana();
		rest.add(resf);
		rest.add(resfds);
		resc = new RestriccionComposite(rest);
	}
	@Test
	void testRestriccionComposite() {
		assertFalse(resc.esFechaPermitida(LocalDate.of(2022, Month.OCTOBER, 20)));
		assertTrue(resc.esFechaPermitida(LocalDate.of(2022, Month.OCTOBER, 22)));
		assertTrue(resc.esFechaPermitida(LocalDate.of(2022, Month.OCTOBER, 30)));
		assertFalse(resc.esFechaPermitida(LocalDate.of(2022, Month.NOVEMBER, 1)));
		resc.eliminarRestriccion(resfds);
		resc.agregarRestriccion(resdds);
		assertTrue(resc.esFechaPermitida(LocalDate.of(2022, Month.OCTOBER, 20)));
		assertFalse(resc.esFechaPermitida(LocalDate.of(2022, Month.OCTOBER, 22)));
		assertFalse(resc.esFechaPermitida(LocalDate.of(2022, Month.OCTOBER, 30)));
		assertTrue(resc.esFechaPermitida(LocalDate.of(2022, Month.NOVEMBER, 1)));
	}

}

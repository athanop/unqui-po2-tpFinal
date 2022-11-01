package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreferenciaTestCase {

	Preferencia pref;

	@BeforeEach
	void setUp() throws Exception {

		pref = new Preferencia(3, 20, 4);

	}

	@Test
	void testLaPreferenciaConoceSuNivelDeDificultadSuRecompensaYSuCantidadDeMuestras() {
		assertEquals(pref.getDificultad(), 3);
		assertEquals(pref.getRecompensa(), 20);
		assertEquals(pref.getCantidadDeMuestras(), 4);
	}

}

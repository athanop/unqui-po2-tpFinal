package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreferenciaTestCase {

	Preferencia pref;
	
	@BeforeEach
	void setUp() throws Exception {
	
		pref = new Preferencia(3, 20d, 4);	
		
	}

	@Test
	void testLaPreferenciaConoceSuNivelDeDificultadSuRecompensaYSuCantidadDeMuestras() {
		assertEquals(pref.getDificultad(), 3);
		assertEquals(pref.getRecompensa(), 20d);
		assertEquals(pref.getCantidadDeMuestras(), 4);
	}

}

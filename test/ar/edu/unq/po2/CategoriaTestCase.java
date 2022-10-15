package ar.edu.unq.po2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriaTestCase {

	Categoria astronomia;
	
	@BeforeEach
	void setUp() throws Exception {
	
		astronomia = new Categoria("Astronomia");
		
	}

	@Test
	void testUnaCategoriaSabeCualEsSuTipo() {
		
		assertEquals(astronomia.getTipoCategoria(), "Astronomia");
		
	}

}

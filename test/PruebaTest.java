import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PruebaTest {

	@BeforeEach
	void setUp() throws Exception {}

	@Test
	void test() {
		Prueba prueba = new Prueba("probanding");
		String nombrePrueba = "probanding";
		assertEquals(nombrePrueba, prueba.getAsd());
	}

}
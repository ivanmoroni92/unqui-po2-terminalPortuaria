import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TruckTest {
	// clase que testea que la instancia del truck se cree correctamente
    @Mock
	private Truck viajarSeguros ;
  
    
    @BeforeEach
    void setUp() {
    	viajarSeguros = mock(Truck.class) ;
		
    }
	@Test
	void testNameEquals() {
		Truck truck = new Truck("Iveco");
		String truckName = "Iveco";
		
		assertEquals(truckName, truck.getName());
	}


	@Test
	void testNameNotEquals() {
		Truck truck = new Truck("Iveco2");
		String truckName = "Iveco";
		assertNotEquals(truckName, truck.getName());
	}
	
	@Test
	void testNameIsEqualsMock() {
		when(viajarSeguros.getName()).thenReturn("viajarSeguros") ;
		assertEquals("viajarSeguros", viajarSeguros.getName());	
		
	}

	@Test
	void testNameIsNotEqualsMock() {
		when(viajarSeguros.getName()).thenReturn("viajarSeguros") ;
		assertNotEquals("viajarSeguros2", viajarSeguros.getName());

	}

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TruckTest {
	// clase que testea que la instancia del truck se cree correctamente

	@Test
	void testNameEquals() {
		Truck truck = new Truck("Iveco");
		String nobmreDelTruck = "Iveco";
		assertEquals(nobmreDelTruck, truck.getName());
	}


	@Test
	void testNameNotEquals() {
		Truck truck = new Truck("Iveco2");
		String nobmreDelTruck = "Iveco";
		assertNotEquals(nobmreDelTruck, truck.getName());
	}

}

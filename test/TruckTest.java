import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TruckTest {
	// clase que testea que la instancia del truck se cree correctamente

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

}

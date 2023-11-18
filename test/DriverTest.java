import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

public class DriverTest {
	
	@Test
	void testDriverEqualsName() {
		Driver driver = new Driver("Guillermo");
		String driverName = "Guillermo";
		assertEquals(driverName, driver.getName());
	}
	
	@Test
	void testDriverNotEqualsName() {
		Driver driver = new Driver("Guillermo");
		String driverName = "Pepe";
		assertNotEquals(driverName, driver.getName());
	}
}

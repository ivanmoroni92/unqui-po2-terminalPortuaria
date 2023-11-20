import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CarrierTest {
	
	@Mock private Truck  truck1 ;
	@Mock private Truck  truck2 ;
	@Mock private Truck  truck3 ;
	@Mock private Driver driver1 ;
	@Mock private Driver driver2 ;
	private Carrier carrier;

	@BeforeEach
	void setUp() throws Exception {
	truck1 = mock(Truck.class) ;
	truck2 = mock(Truck.class) ;
	truck3 = mock(Truck.class);
	driver1 = mock (Driver.class);
	driver2 =  mock (Driver.class);;
	carrier = new Carrier("containerTransporter"); 
	
	  
	}
	 // se testea que el nombre del Carrier sea el correspondiente
	@Test
	void testCarrierName() {
		assertEquals("containerTransporter", carrier.getName());
	}
	
	// se testea que se pueda agregar un Truck al  Carrier
	@Test
	void testAddTruck () {
		carrier.addTruck(truck1);
		carrier.addTruck(truck2);
		carrier.addTruck(truck3);
		
		assertEquals(3, carrier.getTrucks().size());
		
	}
	
	// se testea que se pueda agregar un Driver al Carrier
	@Test
	void testAddDriver () {
		carrier.addDriver(driver1);
		carrier.addDriver(driver2);

		assertEquals(2, carrier.getDrivers().size());
		
	}
	
	// se testea si el Driver pertenece al Carrier 
	@Test
	void testIsFoundDriver() {
		carrier.addDriver(driver1);
		assertTrue(carrier.containsDriver(driver1));
		
	}
	
	// se testea si el Driver no pertenece  al Carrier 
	@Test
	void testIsNotFoundDriver() {
		carrier.addDriver(driver1);
		assertFalse(carrier.containsDriver(driver2));
		
	}
	
	// se testea si el Truck  pertenece  al Carrier 
	
	@Test
	void testIsFoundTruck() {
		carrier.addTruck(truck1);
		carrier.addTruck(truck2);
		assertTrue(carrier.containsTruck(truck1));
		assertTrue(carrier.containsTruck(truck2));
		
	}
	
	
	// se testea si el Truck no pertenece  al Carrier 
	
	@Test
	void testIsNotFoundTruck() {
		carrier.addTruck(truck1);
		assertFalse(carrier.containsTruck(truck3));
		
	}
	


}

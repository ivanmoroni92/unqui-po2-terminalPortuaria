import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ConsigneeOrderTest {
	
	private ConsigneeOrder order;
	@Mock private Client client;
	@Mock private Container container;
	@Mock private Truck truck;
	@Mock private Driver driver;
	@Mock private Travel travel;
	@Mock private IService weighing;
	@Mock private IService powerSupply;
	@Mock private IService washing;
	@Mock private Terminal targetTerminal;
	@Mock private ShippingRoute shippingRoute;
	

	@BeforeEach
	void setUp() throws Exception {
		
	    client = mock(Client.class);
	    container = mock(Container.class);
	    truck = mock (Truck.class);
	    driver = mock (Driver.class);
	    travel = mock(Travel.class);
		weighing = mock (IService.class);
		powerSupply =mock (IService.class);
		washing = mock (IService.class);
		shippingRoute = mock(ShippingRoute.class);
		order = new ConsigneeOrder("345868-2", client, container, truck, driver, travel);
		
	
	}
	
	@Test
	void testEqualsGetClient() {
		when(client.getName()).thenReturn("Ivan");
		
		assertEquals("Ivan", order.getClient().getName());
		verify(client ,times(1)).getName();
	}
	
	@Test
	void testNotEqualsGetClient() {
		when(client.getName()).thenReturn("Lucas");
		
		assertNotEquals("Ivan", order.getClient().getName());
		verify(client ,times(1)).getName();
	}
	
	@Test
	void testGetContainer() {
		when(container.getHeigth()).thenReturn(9.5);
		
		assertEquals(9.5, order.getContainer().getHeigth());
		verify(container ,times(1)).getHeigth();
	}
	
	@Test
	void testGetTruck() {
		when(truck.getName()).thenReturn("F-100");
		
		assertEquals("F-100", order.getTruck().getName());
		verify(truck ,times(1)).getName();
	}
	
	@Test
	void testGetDriver() {
		when(driver.getName()).thenReturn("Terry");
		
		assertEquals("Terry", order.getDriver().getName());
		verify(driver ,times(1)).getName();
	}
	
	@Test
	void testServicesPrice() {

		when(weighing.chargeForUse(container)).thenReturn(5.10);
		when(powerSupply.chargeForUse(container)).thenReturn(3.15);
		when(washing.chargeForUse(container)).thenReturn(2.25);
		
		order.addService(weighing);
		order.addService(powerSupply);
		order.addService(washing);
		
		
		assertEquals(10.50, order.getServicesPrice());
		verify(weighing ,times(1)).chargeForUse(container);
		verify(powerSupply ,times(1)).chargeForUse(container);
		verify(washing ,times(1)).chargeForUse(container);
	}
	
	@Test
	void testOrderPriceWithTravel() {

		when(weighing.chargeForUse(container)).thenReturn(100.0);
		when(powerSupply.chargeForUse(container)).thenReturn(30.15);
		when(washing.chargeForUse(container)).thenReturn(20.00);
		when(travel.getRoute()).thenReturn(shippingRoute);
		when(travel.getTotalPriceUntilTerminal(targetTerminal)).thenReturn(10000.0);
		
		order.addService(weighing);
		order.addService(powerSupply);
		order.addService(washing);
		
		assertEquals(10150.15, order.getOrderPrice());
		verify(weighing ,times(1)).chargeForUse(container);
		verify(powerSupply ,times(1)).chargeForUse(container);
		verify(washing ,times(1)).chargeForUse(container);
		verify(travel ,times(1)).getTotalPriceUntilTerminal(targetTerminal);
	}

}

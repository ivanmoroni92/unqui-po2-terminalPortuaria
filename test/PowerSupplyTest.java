import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PowerSupplyTest {
	
	@Mock private DryContainer dryContainerTest;
	@Mock private RefeerContainer refeerContainerTest;
	@Mock private TankContainer tankContainerTest;
	private PowerSupply powerSupplyTest;
	
	private Double costOfKWTest;
	
	
	@BeforeEach
	void setUp() {
		dryContainerTest = mock(DryContainer.class);
		refeerContainerTest = mock(RefeerContainer.class);
		tankContainerTest = mock(TankContainer.class);
		costOfKWTest = 100.0;
		powerSupplyTest = new PowerSupply(costOfKWTest, "Power Supply");

	}
	
	@Test
	void testName() {
		assertEquals("Power Supply", powerSupplyTest.getServiceName());
	}
	
	@Test
	void testEqualsGetCostOfKW() {
		
		assertEquals(100.0, powerSupplyTest.getCostOfKW());
	}
	
	@Test
	void testNotEqualsGetCostOfKW() {
		
		assertNotEquals(100.1, powerSupplyTest.getCostOfKW());
	}
	
	@Test
	void testEqualsDryContainerChargeForUse() {
		
		when(dryContainerTest.getConsumePerHour()).thenReturn(0.0);
		assertEquals(0.0, powerSupplyTest.chargeForUse(dryContainerTest));
		verify(dryContainerTest, times(1)).getConsumePerHour();
	}
	
	@Test
	void testNotEqualsDryContainerChargeForUse() {
		
		when(dryContainerTest.getConsumePerHour()).thenReturn(0.0);
		assertNotEquals(1.0, powerSupplyTest.chargeForUse(dryContainerTest));
		verify(dryContainerTest, times(1)).getConsumePerHour();
	}
	
	@Test
	void testEqualsTankContainerChargeForUse() {
		
		when(tankContainerTest.getConsumePerHour()).thenReturn(0.0);
		assertEquals(0.0, powerSupplyTest.chargeForUse(tankContainerTest));
		verify(tankContainerTest, times(1)).getConsumePerHour();
	}
	
	@Test
	void testEqualsRefeerContainerChargeForUse() {
		
		powerSupplyTest.setHoursConnected(5.0);
		when(refeerContainerTest.getConsumePerHour()).thenReturn(2.0);
		assertEquals(1000.0, powerSupplyTest.chargeForUse(refeerContainerTest));
		verify(refeerContainerTest, times(1)).getConsumePerHour();
	}
	
	@Test
	void testNotEqualsRefeerContainerChargeForUse() {
		
		powerSupplyTest.setHoursConnected(8.0);
		when(refeerContainerTest.getConsumePerHour()).thenReturn(4.0);
		assertNotEquals(1000.0, powerSupplyTest.chargeForUse(refeerContainerTest));
		verify(refeerContainerTest, times(1)).getConsumePerHour();
	}

void testEqualsRefeerContainerZeroHoursChargeForUse() {
		
		when(refeerContainerTest.getConsumePerHour()).thenReturn(2.0);
		assertEquals(0.0, powerSupplyTest.chargeForUse(refeerContainerTest));
		verify(refeerContainerTest, times(1)).getConsumePerHour();
	}
}

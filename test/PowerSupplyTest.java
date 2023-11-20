import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PowerSupplyTest {
	
	@Mock private DryContainer dryContainerTest;
	@Mock private RefeerContainer refeerContainerTest;
	@Mock private TankContainer tankContainerTest;
	private PowerSupply powerSupplyTest;
	
	private Double costOfKWTest;
	private Double zeroHoursConected;
	private Double tenHoursConected;
	private Double fiftyHoursConected;
	
	@BeforeEach
	void setUp() {
		dryContainerTest = mock(DryContainer.class);
		refeerContainerTest = mock(RefeerContainer.class);
		tankContainerTest = mock(TankContainer.class);
		costOfKWTest = 100.0;
		powerSupplyTest = new PowerSupply(costOfKWTest);
		zeroHoursConected = 0.0;
		tenHoursConected = 10.0;
		fiftyHoursConected = 50.0;
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
		
		assertEquals(0.0, powerSupplyTest.chargeForUse(dryContainerTest,tenHoursConected));
	}
	
	@Test
	void testEqualsTankContainerChargeForUse() {
		
		assertEquals(0.0, powerSupplyTest.chargeForUse(tankContainerTest,tenHoursConected));
	}
	
	@Test
	void testEqualsRefeerContainerChargeForUse() {
		
		assertEquals(0.0, powerSupplyTest.chargeForUse(refeerContainerTest,tenHoursConected));
	}

}

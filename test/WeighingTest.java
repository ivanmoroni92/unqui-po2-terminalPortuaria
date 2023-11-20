import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class WeighingTest {
	
	@Mock private DryContainer dryContainerTest;
	@Mock private RefeerContainer refeerContainerTest;
	@Mock private TankContainer tankContainerTest;
	private Weighing weighingTest;
	private Double fixedPriceTest;

	@BeforeEach
	void setUp() {
		dryContainerTest = mock(DryContainer.class);
		refeerContainerTest = mock(RefeerContainer.class);
		tankContainerTest = mock(TankContainer.class);
		fixedPriceTest = 10.0;
		weighingTest = new Weighing(fixedPriceTest);
		
	}
	
	@Test
	void testEqualsGetFixedPriceTest() {
		
		assertEquals(10.0, weighingTest.getFixedPrice());
	}
	
	@Test
	void testNotEqualsGetFixedPriceTest() {
		
		assertNotEquals(1.0, weighingTest.getFixedPrice());
	}
	
	@Test
	void testEqualsDryContainerChargeForUse() {
		
		assertEquals(10.0, weighingTest.chargeForUse(dryContainerTest, 25.0));
	}
	
	@Test
	void testEqualsRefeerContainerChargeForUse() {
		
		assertEquals(10.0, weighingTest.chargeForUse(refeerContainerTest, 5.0));
	}
	
	@Test
	void testEqualsTankContainerChargeForUse() {
		
		assertEquals(10.0, weighingTest.chargeForUse(tankContainerTest, 2.0));
	}

}

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ExcessStorageTest {
	
	@Mock private DryContainer dryContainerTest;
	@Mock private RefeerContainer refeerContainerTest;
	@Mock private TankContainer tankContainerTest;
	private ExcessStorage excessStorage;
	private Double fixedPriceTest;
	
	@BeforeEach
	void setUp() {
		dryContainerTest = mock(DryContainer.class);
		refeerContainerTest = mock(RefeerContainer.class);
		tankContainerTest = mock(TankContainer.class);
		fixedPriceTest = 100.0;
		excessStorage = new ExcessStorage(fixedPriceTest, "Excess Storage");
		
	}
	
	@Test
	void testName() {
		assertEquals("Excess Storage", excessStorage.getServiceName());
	}
	
	@Test
	void testEqualsFixedPrice() {
		assertEquals(100.0, excessStorage.getFixedPrice());
	}
	
	@Test
	void testNotEqualsFixedPrice() {
		assertNotEquals(100.2, excessStorage.getFixedPrice());
	}
	
	@Test
	void testEqualsZeroDaysOfExcess() {
		assertEquals(0, excessStorage.chargeForUse(dryContainerTest));
	}
	
	@Test
	void testNotEqualsZeroDaysOfExcess() {
		excessStorage.setDaysOfExcess(1.0);
		assertNotEquals(0, excessStorage.chargeForUse(dryContainerTest));
	}
	
	@Test
	void testEqualsOneDaysOfExcess() {
		excessStorage.setDaysOfExcess(1.0);
		assertEquals(100.0, excessStorage.chargeForUse(refeerContainerTest));
	}
	
	@Test
	void testNotEqualsOneDaysOfExcess() {
		excessStorage.setDaysOfExcess(2.0);
		assertNotEquals(100.0, excessStorage.chargeForUse(refeerContainerTest));
	}
	
	@Test
	void testEqualsTwoDaysOfExcess() {
		excessStorage.setDaysOfExcess(2.0);
		assertEquals(200.0, excessStorage.chargeForUse(tankContainerTest));
	}
	
	@Test
	void testNotEqualsTwoDaysOfExcess() {
		excessStorage.setDaysOfExcess(3.0);
		assertNotEquals(200.0, excessStorage.chargeForUse(tankContainerTest));
	}
}

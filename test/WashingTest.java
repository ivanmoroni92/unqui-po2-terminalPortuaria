import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class WashingTest {
	
	@Mock private DryContainer dryContainerTest;
	@Mock private RefeerContainer refeerContainerTest;
	
	private Washing washingTest;
	private Double priceForMinVolumeTest;
	private Double priceForMaxVolumeTest;
	private Double volumeConditionTest;

	@BeforeEach
	void setUp() {
		dryContainerTest = mock(DryContainer.class);
		refeerContainerTest = mock(RefeerContainer.class);
		priceForMinVolumeTest = 50.0;
		priceForMaxVolumeTest = 100.0;
		volumeConditionTest = 70.0;
		washingTest = new Washing(priceForMinVolumeTest, priceForMaxVolumeTest, volumeConditionTest, "Washing");
		
	}
	
	@Test
	void testName() {
		assertEquals("Washing", washingTest.getServiceName());
	}

	@Test
	void testGetMinVolume() {
		assertEquals(50.0, washingTest.getPriceForMinVolume());
	}
	
	@Test
	void testGetMaxVolume() {
		assertEquals(100.0, washingTest.getPriceForMaxVolume());
	}
	
	@Test
	void testGetVolumeCondition() {
		assertEquals(70.0, washingTest.getVolumeCondition());
	}
	
	@Test
	void testPriceForMinVolume() {
		
		when(dryContainerTest.getVolume()).thenReturn(70.0);
		assertEquals(50.0, washingTest.chargeForUse(dryContainerTest));
		verify(dryContainerTest, times(1)).getVolume();
	}
	
	@Test
	void testPriceForMaxVolume() {
		
		when(refeerContainerTest.getVolume()).thenReturn(70.1);
		assertEquals(100.0, washingTest.chargeForUse(refeerContainerTest));
		verify(refeerContainerTest, times(1)).getVolume();
	}
}

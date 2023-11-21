import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

class ExcessStorageTest {
	
	@Mock
	private Container containerTest;
	private ExcessStorage excessStorage;
	private Double fixedPriceTest;
	private Double zeroDayOfExcess;
	private Double oneDayOfExcess;
	private Double twoDayOfExcess;
	
	@BeforeEach
	void setUp() {
		containerTest = mock(Container.class) ;
		fixedPriceTest = 100.0;
		excessStorage = new ExcessStorage(fixedPriceTest);
		zeroDayOfExcess = 0.0;
		oneDayOfExcess = 1.0;
		twoDayOfExcess = 2.0;
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
		assertEquals(0, excessStorage.chargeForUse(containerTest, zeroDayOfExcess));
	}
	
	@Test
	void testNotEqualsZeroDaysOfExcess() {
		assertNotEquals(0, excessStorage.chargeForUse(containerTest, oneDayOfExcess));
	}
	
	@Test
	void testEqualsOneDaysOfExcess() {
		assertEquals(100.0, excessStorage.chargeForUse(containerTest, oneDayOfExcess));
	}
	
	@Test
	void testNotEqualsOneDaysOfExcess() {
		assertNotEquals(100.0, excessStorage.chargeForUse(containerTest, twoDayOfExcess));
	}
	
	@Test
	void testEqualsTwoDaysOfExcess() {
		assertEquals(200.0, excessStorage.chargeForUse(containerTest, twoDayOfExcess));
	}
	
	@Test
	void testNotEqualsTwoDaysOfExcess() {
		assertNotEquals(200.0, excessStorage.chargeForUse(containerTest, zeroDayOfExcess));
	}
}

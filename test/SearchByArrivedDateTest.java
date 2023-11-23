import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SearchByArrivedDateTest {
	
	private SearchByArrivedDate search ;
	@Mock private Terminal destiny ;
	@Mock private Travel travel ;
	private LocalDateTime clientDate ;
	private LocalDateTime travelDate ;
	
	

	@BeforeEach
	void setUp() {
		destiny = mock(Terminal.class);
		travel =  mock(Travel.class);
		
		
	}

	@Test
	void testSearchCriteriaEQualsTrue() {
		//el buscador se configura para busque fechas iguales a las que resibe como parametro
		clientDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		travelDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		when(travel.getArrivalDate(destiny)).thenReturn(travelDate);
		search = new SearchByArrivedDate(clientDate, Criteria.EQUALS, destiny);
		assertTrue(search.markedFilter(travel));
		verify(travel,times(1)).getArrivalDate(destiny);
	}
	
	@Test
	void testSearchCriteriaEQualsFalse() {
		//el buscador se configura para busque fechas iguales a las que resibe como parametro
		travelDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		clientDate = LocalDateTime.of(2024, 2, 10, 15, 30);
		when(travel.getArrivalDate(destiny)).thenReturn(travelDate);
		search = new SearchByArrivedDate(clientDate, Criteria.EQUALS, destiny);
		assertFalse(search.markedFilter(travel));
		verify(travel,times(1)).getArrivalDate(destiny);
	}
	@Test
	void testSearchCriteriaGreatherThanTrue() {
		//el buscador se configura para busque fechas mayores a las que resibe como parametro
		travelDate = LocalDateTime.of(2024, 10, 27, 15, 30);
		clientDate = LocalDateTime.of(2024, 2, 10, 15, 30);
		when(travel.getArrivalDate(destiny)).thenReturn(travelDate);
		search = new SearchByArrivedDate(clientDate, Criteria.GREATHERTHAN, destiny);
		assertTrue(search.markedFilter(travel));
		verify(travel,times(1)).getArrivalDate(destiny);
	}
	
	@Test
	void testSearchCriteriaGreatherThanFalse() {
		//el buscador se configura para busque fechas mayores a las que resibe como parametro
		travelDate = LocalDateTime.of(2024, 10, 27, 15, 30);
		clientDate = LocalDateTime.of(2024, 11, 10, 15, 30);
		when(travel.getArrivalDate(destiny)).thenReturn(travelDate);
		search = new SearchByArrivedDate(clientDate, Criteria.GREATHERTHAN, destiny);
		assertFalse(search.markedFilter(travel));
		verify(travel,times(1)).getArrivalDate(destiny);
	}
	
	@Test
	void testSearchCriteriaLessThanTrue() {
		//el buscador se configura para busque fechas menores a las que resibe como parametro
		travelDate = LocalDateTime.of(2024, 10, 27, 15, 30);
		clientDate = LocalDateTime.of(2024, 10, 31, 15, 30);
		when(travel.getArrivalDate(destiny)).thenReturn(travelDate);
		search = new SearchByArrivedDate(clientDate, Criteria.LESSTHAN, destiny);
		assertTrue(search.markedFilter(travel));
		verify(travel,times(1)).getArrivalDate(destiny);
	}
	
	@Test
	void testSearchCriteriaLessThanFalse() {
		//el buscador se configura para busque fechas menores a las que resibe como parametro
		travelDate = LocalDateTime.of(2024, 10, 31, 15, 30);
		clientDate = LocalDateTime.of(2024, 10, 31, 00, 30);
		when(travel.getArrivalDate(destiny)).thenReturn(travelDate);
		search = new SearchByArrivedDate(clientDate, Criteria.LESSTHAN, destiny);
		assertFalse(search.markedFilter(travel));
		verify(travel,times(1)).getArrivalDate(destiny);
	}

}

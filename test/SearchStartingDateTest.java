import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SearchStartingDateTest {
	
	private SearchByStartingDate search ;
	@Mock private Travel travel ;
	private LocalDateTime clientDate ;
	private LocalDateTime travelDate ;
	

	@BeforeEach
	void setUp() throws Exception {
		travel =  mock(Travel.class);
	}

	@Test
	void testSearchCriteriaEQualsTrue() {
		//el buscador se configura para busque fechas iguales a las que resibe como parametro
		clientDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		travelDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		when(travel.getStartingDate()).thenReturn(travelDate);
		search = new SearchByStartingDate(clientDate, Criteria.EQUALS);
		assertTrue(search.markedFilter(travel));
		verify(travel,times(1)).getStartingDate();
	}
	
	@Test
	void testSearchCriteriaEQualsFalse() {
		//el buscador se configura para busque fechas iguales a las que resibe como parametro
		clientDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		travelDate = LocalDateTime.of(2023, 11, 22, 15, 29);
		when(travel.getStartingDate()).thenReturn(travelDate);
		search = new SearchByStartingDate(clientDate, Criteria.EQUALS);
		assertFalse(search.markedFilter(travel));
		verify(travel,times(1)).getStartingDate();
	}
	
	@Test
	void testSearchCriteriaGreatherThanTrue() {
		//el buscador se configura para busque fechas mayores a las que resibe como parametro
		clientDate = LocalDateTime.of(2023, 11, 22, 15, 30);
		travelDate = LocalDateTime.of(2023, 11, 23, 15, 29);
		when(travel.getStartingDate()).thenReturn(travelDate);
		search = new SearchByStartingDate(clientDate, Criteria.GREATHERTHAN);
		assertTrue(search.markedFilter(travel));
		verify(travel,times(1)).getStartingDate();
	}
	
	@Test
	void testSearchCriteriaGreatherThanFalse() {
		//el buscador se configura para busque fechas mayores a las que resibe como parametro
		clientDate = LocalDateTime.of(2020, 2, 22, 15, 30);
		travelDate = LocalDateTime.of(2019, 11, 23, 15, 29);
		when(travel.getStartingDate()).thenReturn(travelDate);
		search = new SearchByStartingDate(clientDate, Criteria.GREATHERTHAN);
		assertFalse(search.markedFilter(travel));
		verify(travel,times(1)).getStartingDate();
	}
	
	
	@Test
	void testSearchCriteriaLessThanTrue() {
		//el buscador se configura para busque fechas menores a las que resibe como parametro
		travelDate = LocalDateTime.of(2024, 10, 27, 15, 30);
		clientDate = LocalDateTime.of(2024, 10, 31, 15, 30);
		when(travel.getStartingDate()).thenReturn(travelDate);
		search = new SearchByStartingDate(clientDate, Criteria.LESSTHAN);
		assertTrue(search.markedFilter(travel));
		verify(travel,times(1)).getStartingDate();
	}
	
	@Test
	void testSearchCriteriaLessThanFalse() {
		//el buscador se configura para busque fechas menores a las que resibe como parametro
		travelDate = LocalDateTime.of(2024, 10, 31, 15, 30);
		clientDate = LocalDateTime.of(2024, 10, 31, 00, 30);
		when(travel.getStartingDate()).thenReturn(travelDate);
		search = new SearchByStartingDate(clientDate, Criteria.LESSTHAN);
		assertFalse(search.markedFilter(travel));
		verify(travel,times(1)).getStartingDate();
	}


}

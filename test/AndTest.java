import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class AndTest {
	
	private And and ;
	@Mock Travel travel ;
	@Mock ISearchEngine SearchByStartingDate;
	@Mock ISearchEngine SearchByTerminal;

	@BeforeEach
	void setUp() throws Exception {
		travel = mock(Travel.class);
		SearchByStartingDate = mock(ISearchEngine.class);
		SearchByTerminal = mock(ISearchEngine.class);
		and = new And(SearchByStartingDate,SearchByTerminal);
	}

	@Test
	void testAndTrue() {
		when(SearchByStartingDate.markedFilter(travel)).thenReturn(true);
		when(SearchByTerminal.markedFilter(travel)).thenReturn(true);
		assertTrue(and.markedFilter(travel));
		
	}
	
	@Test
	void testAndFalse() {
		when(SearchByStartingDate.markedFilter(travel)).thenReturn(false);
		when(SearchByTerminal.markedFilter(travel)).thenReturn(true);
		assertFalse(and.markedFilter(travel));
		
	}
	
	@Test
	void testAndFalse2() {
		when(SearchByStartingDate.markedFilter(travel)).thenReturn(false);
		when(SearchByTerminal.markedFilter(travel)).thenReturn(false);
		assertFalse(and.markedFilter(travel));
		
	}

}

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SearchByTerminalTest {
	private SearchByTerminal search ;
	@Mock Travel travel ;
	@Mock private ShippingRoute route;
	@Mock private Terminal Terminal ;

	@BeforeEach
	void setUp()  {
		travel =  mock(Travel.class);
		route =  mock(ShippingRoute.class);
		Terminal =  mock(Terminal.class);
		
		when(travel.getRoute()).thenReturn(route);
		when(route.getDestiny()).thenReturn(Terminal);
		when(Terminal.getName()).thenReturn("Acapulco");
		
		search = new SearchByTerminal("Acapulco");
		
	}

	@Test
	void testMarkedFilter() {
		assertTrue( search.markedFilter(travel));		
	}

}

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class OutboundTest {
	
	private State outbound ;
	@Mock Ship ship ;
	private IManagedTerminal terminal ;

	@BeforeEach
	void setUp() throws Exception {
		outbound = new Outbound();
		ship = mock(Ship.class);
		terminal = mock(IManagedTerminal.class);
	}

	@Test
	void testUpdateState() {
		outbound.updateState(ship, terminal);
		//verify(terminal,times(1)).setState(State);
	}

}

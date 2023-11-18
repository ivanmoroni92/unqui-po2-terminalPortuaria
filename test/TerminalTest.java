import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Point;

import org.junit.jupiter.api.Test;

public class TerminalTest {
	
	@Test
	void testTerminalNombreEquals() {
		Point positionZero = new Point(0,0);
		Terminal terminal = new Terminal("Buenos Aires", positionZero);
		String terminalName = "Buenos Aires";
		assertEquals(terminalName, terminal.getName());
	}
	
	@Test
	void testTerminalNombreNotEquals() {
		Point positionZero = new Point(0,0);
		Terminal terminal = new Terminal("Buenos Aires", positionZero);
		String terminalName = "Montevideo";
		assertNotEquals(terminalName, terminal.getName());
	}

}

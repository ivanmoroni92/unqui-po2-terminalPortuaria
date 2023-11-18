import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.*;



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
	
	@Test
	void testTerminalPositionEquals() {
		Point positionZero = new Point(0,0);
		Terminal terminal = new Terminal("Buenos Aires", positionZero);
		Point positionTest = new Point(0,0);
		assertEquals(positionTest, terminal.getPosition());
	}
	
	@Test
	void testTerminalPositionNotEquals() {
		Point positionZero = new Point(0,0);
		Terminal terminal = new Terminal("Buenos Aires", positionZero);
		Point positionOne = new Point(1,1);
		assertNotEquals(positionOne, terminal.getPosition());
	}

}

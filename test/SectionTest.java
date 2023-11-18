import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class SectionTest {
	
	//Declaro las variables acá por tema de scope
	@Mock private Terminal terminalBsAs;	//Declarar el mock
	@Mock private Terminal terminalMontevideo;	//Declarar el mock
	private Section sectionTest;	//Declarar la variable
	
	//Acá pongo toda la funcionalidad para que se repitan en cada test antes de ejecutar
	@BeforeEach
	void setUp() {
		
		terminalBsAs = mock(Terminal.class); //DOC - Instancio el mock como una clase
		terminalMontevideo = mock(Terminal.class); //DOC - Instancio el mock como una clase
		sectionTest = new Section(terminalBsAs, terminalMontevideo, 1000.0, 5); //SUT - Instancio la clase
		
    }
	

	@Test
	void testStartingTerminalEqualsName() {
		when(terminalBsAs.getName()).thenReturn("Buenos Aires"); //Este es el comportamiento de mi mock, ya que no existe, yo le digo que es lo q quiero que haga
		assertEquals(terminalBsAs.getName(), sectionTest.getStartingTerminal().getName());
		
		verify(terminalBsAs,times(2)).getName();	//verifica cuantas veces se ejecutaron el metodo que quiero
	}
	
	@Test
	void testStartingTerminalNotEqualsName() {
		when(terminalBsAs.getName()).thenReturn("Buenos Aires");
		assertEquals(terminalBsAs.getName(), sectionTest.getStartingTerminal().getName());
		
		verify(terminalBsAs,times(2)).getName();
	}
}

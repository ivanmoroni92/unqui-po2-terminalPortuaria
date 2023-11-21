

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

public class ShippingRouteTest {

    @Mock
    private Section section1;
    @Mock private Section section2;
    @Mock private Section section3;

    @Mock private Terminal terminal1;
    private ShippingRoute shippingRoute;

    @BeforeEach
    void setUp() {
        section1 = mock(Section.class);
        section2 = mock(Section.class);
        section3 = mock(Section.class);
        terminal1= mock(Terminal.class);
        List<Section> sections = new ArrayList<>();
        sections.add(section1);
        sections.add(section2);
        sections.add(section3);
        shippingRoute = new ShippingRoute("ruta1",sections);
    }

    // se testea que la instancia de shipping route funciona correctamente
    @Test
    void testShippingRouteOk(){
        shippingRoute.addSection(section1);
        assertEquals("ruta1",shippingRoute.getName());
        assertEquals(4, shippingRoute.getSections().size());
    }

    @Test
    void testShippingRouteNotOk(){
        assertNotEquals("ruta2",shippingRoute.getName());
        assertNotEquals(5, shippingRoute.getSections().size());
    }

    // se testea que la shipping route calcula bien su precio total
    @Test
    void testShippingRouteGetTotalPriceOk(){
        when(section1.getPrice()).thenReturn(500.0);
        when(section2.getPrice()).thenReturn(300.0);
        when(section3.getPrice()).thenReturn(200.0);
        assertEquals(1000.0, shippingRoute.getTotalPrice());
    }

    @Test
    void testShippingRouteGetTotalPriceNotOk(){
        when(section1.getPrice()).thenReturn(500.0);
        when(section2.getPrice()).thenReturn(300.0);
        when(section3.getPrice()).thenReturn(200.0);
        assertNotEquals(2000.5, shippingRoute.getTotalPrice());
    }

    // se testea que la shipping route calcula bien el tiempo total de recorrido
    @Test
    void testShippingRouteGetTotalTimeOk(){
        when(section1.getTime()).thenReturn(50);
        when(section2.getTime()).thenReturn(10);
        when(section3.getTime()).thenReturn(15);
        assertEquals(75, shippingRoute.getTotalTime());
    }

    @Test
    void testShippingRouteGetTotalTimeNotOk(){
        when(section1.getTime()).thenReturn(50);
        when(section2.getTime()).thenReturn(10);
        when(section3.getTime()).thenReturn(15);
        assertNotEquals(100, shippingRoute.getTotalTime());
    }


    // se testea que la shipping route sabe contestar cual es su ultimo destino
    @Test
    void testShippingRouteGetDestinyOk(){
        when(section3.getStartingTerminal()).thenReturn(terminal1);
        when(terminal1.getName()).thenReturn("Chile");
        assertEquals("Chile", shippingRoute.getDestiny().getName());
        verify(terminal1,times(1)).getName();
        verify(section3,times(1)).getStartingTerminal();
        verify(section1,times(0)).getStartingTerminal();
        verify(section2,times(0)).getStartingTerminal();
    }
}

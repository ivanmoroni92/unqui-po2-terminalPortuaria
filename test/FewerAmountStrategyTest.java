import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FewerAmountStrategyTest {

    private ManagedTerminal origenTerminal;
    private Terminal destinyTerminal;
    private ShippingCompany shippingCompany;
    private ISearchStrategy fewerAmountStrategy;

    @BeforeEach
    void setUp() {
        origenTerminal = mock(ManagedTerminal.class);
        destinyTerminal = mock(Terminal.class);
        shippingCompany = mock(ShippingCompany.class);
        fewerAmountStrategy = new FewerAmountStrategy();
    }

    @Test
    void testFewerAmountStrategy() {
        Travel travel1 = mock(Travel.class);
        Travel travel2 = mock(Travel.class);
        Travel travel3 = mock(Travel.class);

        Section section1 = mock(Section.class);
        Section section2 = mock(Section.class);
        Section section3 = mock(Section.class);

        // Configuración de secciones en los viajes
        List<Section> sections1 = Arrays.asList(section1, section2, section3);
        List<Section> sections2 = Arrays.asList(section1, section2);
        List<Section> sections3 = Arrays.asList(section1, section2, section3);

        when(travel1.getRoute()).thenReturn(mock(ShippingRoute.class));
        when(travel1.getRoute().getSections()).thenReturn(sections1);
        when(section1.getStartingTerminal()).thenReturn(origenTerminal);
        when(section1.getEndingTerminal()).thenReturn(mock(Terminal.class));

        // el travel 2 es el que menos secciones tiene.
        when(travel2.getRoute()).thenReturn(mock(ShippingRoute.class));
        when(travel2.getRoute().getSections()).thenReturn(sections2);
        when(section2.getStartingTerminal()).thenReturn(origenTerminal);
        when(section2.getEndingTerminal()).thenReturn(mock(Terminal.class));

        when(travel3.getRoute()).thenReturn(mock(ShippingRoute.class));
        when(travel3.getRoute().getSections()).thenReturn(sections3);
        when(section3.getStartingTerminal()).thenReturn(origenTerminal);
        when(section3.getEndingTerminal()).thenReturn(mock(Terminal.class));

        // Configuración de mocks y relaciones
        when(origenTerminal.getShippingCompany()).thenReturn((List<ShippingCompany>) shippingCompany);
        when(shippingCompany.getSchedule()).thenReturn(Arrays.asList(travel1, travel2, travel3));

        // Uso de la estrategia para buscar el mejor viaje
        Travel result = fewerAmountStrategy.search(origenTerminal, destinyTerminal);

        // Verificación o aserción del resultado esperado
        assertEquals(travel2, result);
    }
}




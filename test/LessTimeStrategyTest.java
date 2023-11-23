

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LessTimeStrategyTest {

    @Mock
    private ManagedTerminal origenTerminal;
    @Mock private Terminal destinyTerminal;
    @Mock private ShippingCompany shippingCompany;
    private ISearchStrategy lessTimeStrategy;

    @BeforeEach
    void setUp() {
        origenTerminal = mock(ManagedTerminal.class);
        destinyTerminal = mock(Terminal.class);
        shippingCompany = mock(ShippingCompany.class);
        lessTimeStrategy = new LessTimeStrategy();
    }

    @Test
    void testLessTimeStrategy() {
        Travel travel1 = mock(Travel.class);
        Travel travel2 = mock(Travel.class);
        Travel travel3 = mock(Travel.class);

        // el travel 3 en este caso es el que menos tiempo tarda hacia la terminal destino
        when(travel1.getTotalTimeUntilTerminal(destinyTerminal)).thenReturn(250);
        when(travel2.getTotalTimeUntilTerminal(destinyTerminal)).thenReturn(150);
        when(travel3.getTotalTimeUntilTerminal(destinyTerminal)).thenReturn(120);

        List<Travel> schedule = Arrays.asList(travel1, travel2, travel3);

        List<ShippingCompany> shippingCompanies = new ArrayList<>();
        shippingCompanies.add(shippingCompany);
        when(origenTerminal.getShippingCompany()).thenReturn(shippingCompanies);
        when(shippingCompany.getSchedule()).thenReturn(schedule);

        Travel result = lessTimeStrategy.search(origenTerminal, destinyTerminal);

        assertEquals(travel3, result);
    }
}

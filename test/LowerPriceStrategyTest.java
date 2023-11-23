import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

public class LowerPriceStrategyTest {

    @Mock private ManagedTerminal origenTerminal;
    @Mock private Terminal destinyTerminal;
    @Mock private ShippingCompany shippingCompany;
    private ISearchStrategy lowerPriceStrategy;

    @BeforeEach
    void setUp() {
        origenTerminal = mock(ManagedTerminal.class);
        destinyTerminal = mock(Terminal.class);
        shippingCompany = mock(ShippingCompany.class);
        lowerPriceStrategy = new LowerPriceStrategy();
    }

    @Test
    void testLowerPriceStrategy() {
        Travel travel1 = mock(Travel.class);
        Travel travel2 = mock(Travel.class);
        Travel travel3 = mock(Travel.class);

        // el travel 1 en este caso es el mas barato hacia la terminal de destino
        when(travel1.getTotalPriceUntilTerminal(destinyTerminal)).thenReturn(100.0);
        when(travel2.getTotalPriceUntilTerminal(destinyTerminal)).thenReturn(150.0);
        when(travel3.getTotalPriceUntilTerminal(destinyTerminal)).thenReturn(120.0);

        List<Travel> schedule = Arrays.asList(travel1, travel2, travel3);

        when(origenTerminal.getShippingCompany()).thenReturn((List<ShippingCompany>) shippingCompany);
        when(shippingCompany.getSchedule()).thenReturn(schedule);

        Travel result = lowerPriceStrategy.search(origenTerminal, destinyTerminal);

        assertEquals(travel1, result);
    }
}
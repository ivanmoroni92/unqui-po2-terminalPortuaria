

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class ShippingCompanyTest {
    @Mock
    private Ship ship1;
    @Mock private Ship ship2;
    @Mock private ShippingRoute route1;
    @Mock private ShippingRoute route2;
    @Mock private Travel travel1;
    @Mock private Travel travel2;
    private ShippingCompany company;

    @BeforeEach
    void setUp(){
        travel1 = mock(Travel.class);
        travel2 = mock(Travel.class);
        ship1 = mock(Ship.class);
        ship2 = mock(Ship.class);
        route1 = mock(ShippingRoute.class);
        route2 = mock(ShippingRoute.class);



    }

    @Test
    void shippingCompanyOk(){
        List<ShippingRoute> routes = new ArrayList<>();
        routes.add(route1);
        routes.add(route2);

        List<Ship> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);

        List<Travel> schedule = new ArrayList<>();
        schedule.add(travel1);
        schedule.add(travel2);


        company = new ShippingCompany("CompanyTestName", routes,schedule,ships);

        assertEquals("CompanyTestName", company.getName());

        assertEquals(2,company.getShips().size());
        assertEquals(2,company.getSchedule().size());
        assertEquals(2,company.getShippingRoutes().size());
    }
}

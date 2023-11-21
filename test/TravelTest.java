import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TravelTest {

    @Mock private Terminal terminalBuenosAires;
    @Mock private Terminal terminalMexico;
    @Mock private Terminal terminalEstadosUnidos;

    @Mock private Terminal terminalEcuador;
    @Mock private ShippingRoute ruta;

    @Mock private Section sectionBuenosAiresMexico;

    @Mock private Section sectionMexicoEstadosUnidos;

    @Mock private Section sectionEstadosUnidosBuenosAires;

    @Mock private Ship ship;

    private Travel travel;
    private List<Section> sections = new ArrayList<>();

    @BeforeEach
    void setUp(){
        // añadimos una ruta al travel:
        // esa ruta va a estar conformada por 3 secciones
        // buenos aires - mexico , mexico - estados unidos , estados unidos - buenos aires
        // entendiendo a buenosAires como la managedTerminal
        // la fecha de salida del travel es el 3 de diciembre de 2023 a las 3 de la tarde.

        terminalBuenosAires = mock(Terminal.class);
        terminalMexico = mock(Terminal.class);
        terminalEstadosUnidos = mock(Terminal.class);
        terminalEcuador = mock(Terminal.class);
        sectionBuenosAiresMexico = mock(Section.class);
        sectionMexicoEstadosUnidos = mock(Section.class);
        sectionEstadosUnidosBuenosAires = mock(Section.class);
        ship = mock(Ship.class);
        ruta = mock(ShippingRoute.class);

        LocalDateTime startingDate = LocalDateTime.of(2023, 12, 3, 15, 0);

        sections.add(sectionBuenosAiresMexico);
        sections.add(sectionMexicoEstadosUnidos);
        sections.add(sectionEstadosUnidosBuenosAires);

        when(sectionBuenosAiresMexico.getStartingTerminal()).thenReturn(terminalBuenosAires);
        when(sectionBuenosAiresMexico.getEndingTerminal()).thenReturn(terminalMexico);

        when(sectionMexicoEstadosUnidos.getStartingTerminal()).thenReturn(terminalMexico);
        when(sectionMexicoEstadosUnidos.getEndingTerminal()).thenReturn(terminalEstadosUnidos);

        when(sectionEstadosUnidosBuenosAires.getStartingTerminal()).thenReturn(terminalEstadosUnidos);
        when(sectionEstadosUnidosBuenosAires.getEndingTerminal()).thenReturn(terminalBuenosAires);

        when(terminalBuenosAires.getName()).thenReturn("Buenos Aires");
        when(terminalMexico.getName()).thenReturn("Mexico");
        when(terminalEstadosUnidos.getName()).thenReturn("Estados Unidos");

        when(terminalEcuador.getName()).thenReturn("Ecuador"); // terminal que no forma parte de nuestro travel

        when(ruta.getSections()).thenReturn(sections);

        travel = new Travel(startingDate , ruta, ship);
    }


    @Test
    void travelOk(){
        List<Section> sections = new ArrayList<>();
        sections.add(sectionBuenosAiresMexico);
        sections.add(sectionMexicoEstadosUnidos);
        sections.add(sectionEstadosUnidosBuenosAires);
        when(ship.getId()).thenReturn("ship1");
        when(ruta.getSections()).thenReturn(sections);
        assertEquals(LocalDateTime.of(2023, 12, 3, 15, 0), travel.getStartingDate());
        assertEquals(3, travel.getRoute().getSections().size());
        assertEquals("ship1",travel.getShip().getId());
    }


    @Test
    void travelGetArrivalDate(){
        when(sectionBuenosAiresMexico.getTime()).thenReturn(120); // tarda 120 horas en ir de bsas a mx
        when(sectionMexicoEstadosUnidos.getTime()).thenReturn(30);// tarda 30 horas en ir de mx a eeuu
        when(sectionEstadosUnidosBuenosAires.getTime()).thenReturn(180); // tarda 180 horas en volver  de eeuu a bsas

        //teniendo en cuenta que  la fecha de salida del travel es el 3 de diciembre de 2023 a las 3 de la tarde:
        // tarda 120 horas en llegar de bsas a  mx (exactamente 5 dias)
        // por lo tanto de bsas a mx deberia llegar el 8 de diciembre de 2023 a las 3 de la tarde.
        LocalDateTime arrivedMxDate = LocalDateTime.of(2023, 12, 8, 15, 0);
        assertEquals(arrivedMxDate, travel.getArrivalDate(terminalMexico));


        // tarda 30 horas en llegar de mx a eeuu (exactamente 1 dia y 6 horas)
        // por lo tanto de bsas a eeuu deberia llegar el 9 de diciembre de 2023 a las 9 de la noche.
        LocalDateTime arrivedEstadosUnidosDate = LocalDateTime.of(2023, 12, 9, 21, 0);
        assertEquals(arrivedEstadosUnidosDate, travel.getArrivalDate(terminalEstadosUnidos));

        // tarda 180 horas en volver de eeuu a bsas (exactamente 7 dias y 12 horas)
        // por lo tanto en hacer el recorrido entero y volver a bsas deberia llegar el 17 de diciembre de 2023 a las 9 de la mañana.
        LocalDateTime arrivedBsAsDate = LocalDateTime.of(2023, 12, 17, 9, 0);
        assertEquals(arrivedBsAsDate, travel.getArrivalDate(terminalBuenosAires));

        // nos aseguramos que tira la exception si intentamos pasarle una terminal que no forma parte del travel
        assertThrows(IllegalArgumentException.class, () -> travel.getArrivalDate(terminalEcuador));

    }

    @Test
    void travelGetTotalPriceUntilTerminal(){
        when(sectionBuenosAiresMexico.getPrice()).thenReturn(100.0); // Esta seccion cuesta 100
        when(sectionMexicoEstadosUnidos.getPrice()).thenReturn(50.0);// esta seccion cuesta 50
        when(sectionEstadosUnidosBuenosAires.getPrice()).thenReturn(150.5); // esta seccion cuesta 150,5

        // en nuestro travel, ir hasta mexico cuesta 100
        Double precioHastaMx = 100.0;
        assertEquals(precioHastaMx, travel.getTotalPriceUntilTerminal(terminalMexico));

        // en nuestro travel, ir hasta eeuu cuesta 150
        Double precioHastaEEUU = 150.0;
        assertEquals(precioHastaEEUU, travel.getTotalPriceUntilTerminal(terminalEstadosUnidos));

        // en nuestro travel, ir hasta bsas (recorrido completo) sale 300,5
        Double precioHastaBsAs =300.5;
        assertEquals(precioHastaBsAs, travel.getTotalPriceUntilTerminal(terminalBuenosAires));

        // nos aseguramos que tira la exception si intentamos pasarle una terminal que no forma parte del travel
        assertThrows(IllegalArgumentException.class, () -> travel.getArrivalDate(terminalEcuador));
    }
}

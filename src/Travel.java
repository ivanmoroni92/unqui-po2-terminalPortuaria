import java.time.LocalDateTime;
import java.util.Iterator;

public class Travel {
    // la clase travel respresenta a un ship recorriendo una ruta en una fecha de salida determinada.
    private LocalDateTime startingDate;
    private ShippingRoute route;
    private Ship ship;

    public Travel(LocalDateTime startingDate, ShippingRoute route, Ship ship) {
        this.startingDate = startingDate;
        this.route = route;
        this.ship = ship;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public ShippingRoute getRoute() {
        return route;
    }

    public Ship getShip() {
        return ship;
    }

    public LocalDateTime getArrivalDate(Terminal terminal) {
        // metodo que se encarga de devolver la fecha de llegada a una terminal especifica.
        LocalDateTime arrivalDate = startingDate;
        String terminalName = terminal.getName();
        Iterator<Section> sectionIterator = route.getSections().iterator();

        // se recorre la lista de secciones y se va calculando la fecha de llegada en base a la cantidad de horas que se tarda en recorrer esa seccion.
        // asumimos que la lista de secciones esta ordenada en base a como el ship recorre esa ruta.
        // se termina de recorrer cuando se encuentra la terminal deseada o cuando no se encuentra, lanzando una exception.
       while(sectionIterator.hasNext()){
           Section section = sectionIterator.next();
            String endingTerminalName = section.getEndingTerminal().getName();
            arrivalDate = arrivalDate.plusHours(section.getTime());

            if (endingTerminalName.equals(terminalName)) {
                // Cuando encontramos el nombre de la terminal deseada, devolvemos la fecha de llegada a esa terminal.
                return arrivalDate;
            }
        }
        // si la terminal que se desea no forma parte de la ruta, se lanza una exception.
        throw new IllegalArgumentException("El terminal proporcionado no es parte de la ruta del viaje.");
    }

    public Double getTotalPriceUntilTerminal(Terminal targetTerminal) {
        // metodo que se encarga de devolver el precio del viaje hasta una terminal especifica
        Double totalCost = 0.0;
        String targetTerminalName = targetTerminal.getName();
        Iterator<Section> sectionIterator = route.getSections().iterator();

        // se recorre la lista de secciones y se va calculando el precio de cada seccion hasta llegar a la deseada.
        // asumimos que la lista de secciones esta ordenada en base a como el ship recorre esa ruta.
        // se termina de recorrer cuando se encuentra la terminal deseada o cuando no se encuentra, lanzando una exception.
        while (sectionIterator.hasNext()) {
            Section section = sectionIterator.next();
            String endingTerminalName = section.getEndingTerminal().getName();

            // Sumar el precio de la sección actual al total
            totalCost += section.getPrice();

            if (endingTerminalName.equals(targetTerminalName)) {
                // Cuando encontramos el nombre de la terminal deseada, devolvemos el total acumulado.
                return totalCost;
            }
        }

        // Si la terminal que se desea no forma parte de la ruta, se lanza una excepción.
        throw new IllegalArgumentException("La terminal proporcionada no es parte de la ruta del viaje.");
    }


}

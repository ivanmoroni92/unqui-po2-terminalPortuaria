import java.time.LocalDateTime;

public class Travel {
    private LocalDateTime startingDate;
    private ShippingRoute route;

    public Travel(LocalDateTime startingDate, ShippingRoute route) {
        this.startingDate = startingDate;
        this.route = route;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public ShippingRoute getRoute() {
        return route;
    }

    public LocalDateTime getArrivalDate(Terminal terminal) {
        LocalDateTime arrivalDate = startingDate;
        String terminalName = terminal.getName();

        // se recorre la lista de secciones y se va calculando la fecha de llegada en base a la cantidad de horas que se tarda en recorrer esa seccion.
        // asumimos que la lista de secciones esta ordenada en base a como el ship recorre esa ruta.
        for (Section section : route.getSections()) {
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
}

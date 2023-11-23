import java.util.List;

public class LowerPriceStrategy implements ISearchStrategy{


    // estrategia que busca el viaje mas barato hacia la terminal de destino
    public LowerPriceStrategy() {
    }

    @Override
    public Travel search(ManagedTerminal origenTerminal, Terminal destinyTerminal) {
        //todo la managedTerminal puede tener mas de una shippingCompany
        List<Travel> schedule = origenTerminal.getShippingCompany().get(0).getSchedule();

        if (schedule.isEmpty()) {
            throw new IllegalStateException("No hay viajes registrados");
        }
        // Inicializar con el primer travel
        Travel lowestPriceTravel = schedule.get(0);
        Double lowestPrice = calculateTotalPrice(lowestPriceTravel, destinyTerminal);

        // se recorren los travels, y nos vamos quedando con el de menor precio
        // al terminar de recorrer, se devuelve el travel con menor precio
        for (Travel travel : schedule) {
            Double currentPrice = calculateTotalPrice(travel, destinyTerminal);
            if (currentPrice < lowestPrice) {
                lowestPrice = currentPrice;
                lowestPriceTravel = travel;
            }
        }
        return lowestPriceTravel;

    }

    //  se calcula el precio total de un viaje hasta la terminal de destino
    private Double calculateTotalPrice(Travel travel, Terminal destinyTerminal) {
        try {
            return travel.getTotalPriceUntilTerminal(destinyTerminal);
        } catch (IllegalArgumentException e) {
            // Si la terminal de destino no está en el viaje, devolvemos un valor máximo
            return Double.MAX_VALUE;
        }
    }
}

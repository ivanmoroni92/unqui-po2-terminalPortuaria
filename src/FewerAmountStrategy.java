import java.util.List;

public class FewerAmountStrategy implements ISearchStrategy {

    public FewerAmountStrategy() {
    }

    @Override
    public Travel search(ManagedTerminal origenTerminal, Terminal destinyTerminal) {
        List<Travel> travels = origenTerminal.getShippingCompany().getSchedule();

        // Inicializamos las variables para realizar el seguimiento del travel con la menor cantidad de terminales intermedias
        Travel minIntermediateTerminalsTravel = null;
        int minIntermediateTerminals = Integer.MAX_VALUE;

        for (Travel travel : travels) {
            try {
                int intermediateTerminals = calculateIntermediateTerminals(travel, origenTerminal, destinyTerminal);

                // Actualizamos si encontramos un travel con menos terminales intermedias
                if (intermediateTerminals < minIntermediateTerminals) {
                    minIntermediateTerminals = intermediateTerminals;
                    minIntermediateTerminalsTravel = travel;
                }
            } catch (IllegalArgumentException e) {
                // Manejar la excepción si es necesario
            }
        }

        return minIntermediateTerminalsTravel;
    }

    // Método auxiliar para calcular la cantidad de terminales intermedias entre la terminal de origen y destino
    private int calculateIntermediateTerminals(Travel travel, ManagedTerminal origenTerminal, Terminal destinyTerminal) {
        List<Section> sections = travel.getRoute().getSections();
        int intermediateTerminals = 0;

        boolean reachedOriginTerminal = false;

        for (Section section : sections) {
            Terminal startingTerminal = section.getStartingTerminal();
            Terminal endingTerminal = section.getEndingTerminal();

            if (startingTerminal.equals(origenTerminal)) {
                reachedOriginTerminal = true;
            }

            if (reachedOriginTerminal) {
                intermediateTerminals++;

                if (endingTerminal.equals(destinyTerminal)) {
                    break; // Terminamos de contar terminales al llegar a la terminal de destino
                }
            }
        }

        return intermediateTerminals - 1; // Restamos 1 porque no contamos la terminal de origen
    }
}
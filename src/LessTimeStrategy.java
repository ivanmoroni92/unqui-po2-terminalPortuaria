import java.util.Iterator;
import java.util.List;

public class LessTimeStrategy  implements ISearchStrategy{

    // estrategia que busca el viaje mas rapido hacia la temrinal de destino
    public LessTimeStrategy() {
    }

    @Override
    public Travel search(ManagedTerminal origenTerminal, Terminal destinyTerminal) {
        List<Travel> schedule = origenTerminal.getShippingCompany().getSchedule();

        if (schedule.isEmpty()) {
            throw new IllegalStateException("El horario de la compañía de envíos está vacío.");
        }

        // Inicializar con el primer travel
        Travel lessTimeTravel = schedule.get(0);
        int lessTime = calculateTotalTime(lessTimeTravel, destinyTerminal);

        // se recorren los travels, y nos vamos quedando con el de menor tiempo de recorrido en horas
        // al terminar de recorrer, se devuelve el travel con menor tiempo medido en horas.
        for (Travel travel : schedule) {
            int currentTime = calculateTotalTime(travel, destinyTerminal);
            if (currentTime < lessTime) {
                lessTime = currentTime;
                lessTimeTravel = travel;
            }
        }

        return lessTimeTravel;
    }

    // Método auxiliar para calcular el tiempo total de un viaje
    private int calculateTotalTime(Travel travel, Terminal destinyTerminal) {
        List<Section> sections = travel.getRoute().getSections();
        int totalTime = 0;
        boolean foundDestiny = false;
        Iterator<Section> sectionIterator = sections.iterator();
        // se recorren las secciones del travel y se va calculando el tiempo total en horas hasta llegar a la terminal destino
        // si la terminal no se encuentra, se lanza una exception.

        while (sectionIterator.hasNext() && !foundDestiny) {
            Section section = sectionIterator.next();
            totalTime += section.getTime();

            if (section.getEndingTerminal().equals(destinyTerminal)) {
                foundDestiny = true;
            }
        }

        if (!foundDestiny) {
            throw new IllegalArgumentException("La terminal de destino no está en el viaje.");
        }

        return totalTime;
    }

}

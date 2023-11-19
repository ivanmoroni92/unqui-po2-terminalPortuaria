import java.util.List;

public class ShippingRoute {
    private String name;
    private List<Section> sections;

    public ShippingRoute(String name, List<Section> sections) {
        this.name = name;
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public String getName() {
        return name;
    }


    public Double getTotalPrice(){
        // recorre las secciones y suma el precio de cada una
        return this.sections.stream().mapToDouble(section -> section.getPrice()).sum();
    }

    public int getTotalTime(){
        // recorre las secciones y suma el tiempo de cada una
        return this.sections.stream().mapToInt(section -> section.getTime()).sum();
    }

    public Terminal getDestiny(){
        // se toma el size -1 para saber el index de la ultima seccion de la ruta
        // se obtiene la ultima seccion con ese index
        // se le pide su endingTerminal para saber el destino final de la ruta.
        int  lastSectionIndex = this.sections.size() - 1;
        Section lastSection = this.sections.get(lastSectionIndex);
        return lastSection.getEndingTerminal();
    }
}

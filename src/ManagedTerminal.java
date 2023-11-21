import java.awt.*;
import java.util.List;

public class ManagedTerminal extends  Terminal {

    private List<Carrier> carriers;
    private ShippingCompany shippingCompany;
    private List<Client> consignees; // clientes registrados como consignees habilitados que ya vienen con la temrinal
    private List<Client> shippers; // clientes registrados como shippers habilitados que ya vienen con la temrinal

    private ISearchStrategy strategy; //estrategia de busqueda


    public ManagedTerminal(String name, Point position, List<Carrier> carriers, ShippingCompany shippingCompany, List<Client> consignees, List<Client> shippers) {
        super(name, position);
        this.carriers = carriers;
        this.shippingCompany = shippingCompany;
        this.consignees = consignees;
        this.shippers = shippers;
    }

    public List<Carrier> getCarrier() {
        return carriers;
    }

    public ShippingCompany getShippingCompany() {
        return shippingCompany;
    }

    public List<Client> getConsignees() {
        return consignees;
    }

    public List<Client> getShippers() {
        return shippers;
    }


    public void notifyConsignees(){
        // por ahora no hace nada
        //metodo que notificara a los consignees
    }
    public void notifyShippers(){
        // por ahora no hace nada
        // metodo que no tificara a los shippers
    }
    public void notifyClients(){
        // por ahora no hace nada
        // metodo que enviara x mail el desglose de servicios y factura a todos los clientes que se relacionan con el buque que cambio de Departing a  Outbound
    }

    /**
     * Establece la estrategia de búsqueda para seleccionar el mejor Travel.
     * @param strategy La estrategia de búsqueda a establecer.
     */
    public void setStrategy(ISearchStrategy strategy){
        this.strategy= strategy;
    }

    /**
     * searchByStrategy Busca el mejor Travel en base a la estrategia establecida.
     * por ahora tenemos 3 estrategias de busqueda.
     * 1)Menor precio entre la managedTerminal y la destinyTerminal
     * 2)Menos tiempo total de recorrido entre la managedTerminal y la destinyTerminal.
     * 3)Menor cantidad de terminales intermedias entre la managedTerminal y la destinyTerminal.
     * @param destinyTerminal La terminal de destino para la búsqueda.
     * @return El mejor Travel según la estrategia.
     */
    public Travel searchByStrategy( Terminal destinyTerminal){
       return this.strategy.search(this, destinyTerminal);
    }

}

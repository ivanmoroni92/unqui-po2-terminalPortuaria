import java.awt.*;
import java.util.List;

public class ManagedTerminal extends  Terminal {

    private List<Carrier> carriers;
    private ShippingCompany shippingCompany;
    private List<Client> consignees; // clientes registrados como consignees habilitados que ya vienen con la temrinal
    private List<Client> shippers; // clientes registrados como shippers habilitados que ya vienen con la temrinal


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

}

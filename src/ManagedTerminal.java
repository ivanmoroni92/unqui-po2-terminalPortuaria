import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ManagedTerminal extends  Terminal {

    private List<Carrier> carriers;
    private List<ShippingCompany> shippingCompany;
    private List<Client> consignees; // clientes registrados como consignees habilitados que ya vienen con la temrinal
    private List<Client> shippers; // clientes registrados como shippers habilitados que ya vienen con la temrinal


    public ManagedTerminal(String name, Point position, List<Carrier> carriers, List<ShippingCompany>  shippingCompany, List<Client> consignees, List<Client> shippers) {
        super(name, position);
        this.carriers = carriers;
        this.shippingCompany = shippingCompany;
        this.consignees = consignees;
        this.shippers = shippers;
    }

    public List<Carrier> getCarrier() {
        return carriers;
    }

    public List<ShippingCompany> getShippingCompany() {
        return shippingCompany;
    }
    
    
    public void addShippingCompany(ShippingCompany shippingCompany) {
    	this.shippingCompany.add(shippingCompany);
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
     * Busca y filtra viajes de todas las compañías de envío según un criterio de búsqueda proporcionado.
     *
     * Este método toma un objeto que implementa la interfaz {@code ISearchEngine}, el cual
     * define un criterio de búsqueda específico. Luego, busca en la lista de viajes de todas
     * las compañías de envío y filtra los viajes que cumplen con dicho criterio.
     *
     * @param search Objeto que implementa {@code ISearchEngine} y proporciona el criterio de búsqueda.
     * @return Una lista de viajes que cumplen con el criterio de búsqueda especificado.
     */
    
    public List<Travel> searchByCriteria(ISearchEngine search){
    	// Obtener todos los viajes de todas las compañías de envío
    	List<Travel> travels = this.shippingCompany.stream().flatMap(company -> company.getSchedule().stream()).collect(Collectors.toList());
    	List<Travel> filteredTravel = new ArrayList<Travel>() ;
    	
    	
    	for (Travel travel : travels) {
			if(search.markedFilter(travel)) {
				filteredTravel.add(travel);
			}
		}
    	
    	return filteredTravel ;
    		               
    }

}

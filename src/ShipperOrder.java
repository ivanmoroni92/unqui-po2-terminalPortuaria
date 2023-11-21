import java.util.ArrayList;
import java.util.List;

public class ShipperOrder {
	   protected String orderID ;
		protected Container container ;
	    protected Truck truck ;
	    protected Driver driver ;
	    protected Client client ;
	    protected List<IService> services ;
	    protected Travel travel ;
	    protected Terminal destiny;


	    public ShipperOrder(String orderID, Client client ,Container container,Truck truck,Driver driver) {
	        this.orderID = orderID ;
	        this.client = client ;
	        this.container = container ;
	        this.truck = truck ;
	        this.driver = driver ;
	        this.services = new ArrayList<IService>();
	    }
	    
	    
	     public List<IService> getServices() {
	    	 return services;
	     }
	     
	     public void addService(IService service){
		        services.add(service);
		     }




	     public String getOrderID() {
	    	 return orderID;
	     }



	     public Container getContainer() {
	    	 return container;
	     }



	     public Truck getTruck() {
	    	 return truck;
	     }



	     public Driver getDriver() {
	    	 return driver;
	     }



	     public Client getClient() {
	    	 return client;
	     }



	     public Travel getTravel() {
	    	 return travel;
	     }



	     public Terminal getDestiny() {
	    	 return destiny;
	     }



	


	    public double getOrderPrice() {
	        return this.getServicesPrice() ;

	    }
	    
	    



	    protected  double getServicesPrice() {
	        return services.stream()
	                       .mapToDouble(service -> service.chargeForUse(container))
	                       .sum(); 

	    }

}

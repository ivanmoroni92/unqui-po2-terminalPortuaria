
public abstract class Service {
	private Double price;
	
	//Constructor de Clase Service
	
	public Service(Double price) {
		this.price = price;
	}
	
	private Double getPrice() {
		return price;
	}
	
	public abstract Double chargeForUse(Container container);
}

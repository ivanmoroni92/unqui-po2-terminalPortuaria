
public class PowerSupply implements Service{

	private Double costOfKW;
	
	public PowerSupply(Double costOfKW) {
		super();
		this.costOfKW = costOfKW;
	}

	@Override
	public Double chargeForUse(Container container, Order order) {
		return null;
	}

}

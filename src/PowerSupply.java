
public class PowerSupply implements Service{

	private final Double costOfKW;

	public PowerSupply(Double costOfKW) {
		super();
		this.costOfKW = costOfKW;
	}
	
	public Double getCostOfKW() {
		return costOfKW;
	}

	@Override
	public Double chargeForUse(Container container, Order order) {
		return getCostOfKW() * container.getConsumePerHour() * order.calculateUsedTime();
	}

}

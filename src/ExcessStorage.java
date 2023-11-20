
public class ExcessStorage implements Service{
	
	private final Double fixedPrice;
	
	public ExcessStorage(Double fixedPrice) {
		super();
		this.fixedPrice = fixedPrice;
	}
	@Override
	public Double chargeForUse(Container container, Double daysOfExcess) {
		
		return getFixedPrice() * daysOfExcess;
	}
	
	public Double getFixedPrice() {
		return fixedPrice;
	}

}

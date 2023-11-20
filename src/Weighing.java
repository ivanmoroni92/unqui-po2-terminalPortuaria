
public class Weighing implements Service{
	
	private final Double fixedPrice;
	
	public Weighing(Double fixedPrice) {
		super();
		this.fixedPrice = fixedPrice;
	}

	@Override
	public Double chargeForUse(Container container, Double number) {
		
		return getFixedPrice();
	}
	
	public Double getFixedPrice() {
		return fixedPrice;
	}
}

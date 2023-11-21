
public class Weighing implements IService{
	
	private final Double fixedPrice;
	private String serviceName;
	
	public Weighing(Double fixedPrice, String serviceName) {
		super();
		this.fixedPrice = fixedPrice;
		this.serviceName = serviceName;
	}
	
	public String getServiceName() {
		return serviceName;
	}

	@Override
	public Double chargeForUse(Container container) {
		
		return getFixedPrice();
	}
	
	public Double getFixedPrice() {
		return fixedPrice;
	}
}

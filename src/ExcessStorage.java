
public class ExcessStorage implements IService{
	
	private final Double fixedPrice;
	private Double daysOfExcess;
	private String serviceName;
	
	public ExcessStorage(Double fixedPrice, String serviceName) {
		super();
		this.fixedPrice = fixedPrice;
		this.serviceName = serviceName;
		this.daysOfExcess = 0.0;
	}
	
	public Double getDaysOfExcess() {
		return daysOfExcess;
	}

	public void setDaysOfExcess(Double daysOfExcess) {
		this.daysOfExcess = daysOfExcess;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	@Override
	public Double chargeForUse(Container container) {
		
		return getFixedPrice() * daysOfExcess;
	}
	
	public Double getFixedPrice() {
		return fixedPrice;
	}

}

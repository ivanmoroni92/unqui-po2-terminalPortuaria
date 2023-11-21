
public class PowerSupply implements IService{

	private final Double costOfKW;
	private Double hoursConnected;
	private String serviceName;

	public PowerSupply(Double costOfKW, String serviceName) {
		super();
		this.costOfKW = costOfKW;
		this.serviceName = serviceName;
		this.hoursConnected = 0.0;
	}
	
	public Double getHoursConnected() {
		return hoursConnected;
	}
	
	public String getServiceName() {
		return serviceName;
	}

	public void setHoursConnected(Double hoursConnected) {
		this.hoursConnected = hoursConnected;
	}

	public Double getCostOfKW() {
		return costOfKW;
	}

	@Override
	public Double chargeForUse(Container container) {
		return getCostOfKW() * container.getConsumePerHour() * getHoursConnected();
	}

}

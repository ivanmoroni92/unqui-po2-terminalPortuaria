
public class Washing implements IService {
	
	private final Double priceForMinVolume;
	private final Double priceForMaxVolume;
	private final Double volumeCondition;
	private String serviceName;
	
	public Washing(Double priceForMinVolume, Double priceForMaxVolume, Double volumeCondition, String serviceName) {
		super();
		this.priceForMinVolume = priceForMinVolume;
		this.priceForMaxVolume = priceForMaxVolume;
		this.serviceName = serviceName;
		this.volumeCondition = volumeCondition;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	@Override
	public Double chargeForUse(Container container) {
		
		if (container.getVolume() > getVolumeCondition()) {
            return getPriceForMaxVolume();
        } else {
            return getPriceForMinVolume();
        }
	}

	public Double getPriceForMinVolume() {
		return priceForMinVolume;
	}

	public Double getPriceForMaxVolume() {
		return priceForMaxVolume;
	}

	public Double getVolumeCondition() {
		return volumeCondition;
	}
	
}

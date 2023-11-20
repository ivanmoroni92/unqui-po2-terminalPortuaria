
public class Washing implements Service{
	
	private final Double priceForMinVolume;
	private final Double priceForMaxVolume;
	private final Double volumeCondition;
	
	public Washing(Double priceForMinVolume, Double priceForMaxVolume, Double volumeCondition) {
		super();
		this.priceForMinVolume = priceForMinVolume;
		this.priceForMaxVolume = priceForMaxVolume;
		this.volumeCondition = volumeCondition;
	}
	
	@Override
	public Double chargeForUse(Container container, Double number) {
		
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

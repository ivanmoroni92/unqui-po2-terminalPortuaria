
public class ConsigneeOrder extends ShipperOrder {

	
	public ConsigneeOrder(String orderID, Client client, Container container, Truck truck, Driver driver, Travel travel) {
		super(orderID, client, container, truck, driver);
		this.travel = travel;
	}
	
	@Override
	public double getOrderPrice() {
        return super.getOrderPrice() + this.getTravelPrice();

    }

	private double getTravelPrice() {
		return travel.getTotalPriceUntilTerminal(travel.getRoute().getDestiny());
	}
}
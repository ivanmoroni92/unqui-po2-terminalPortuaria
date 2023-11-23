
public class ConsigneeOrder extends ShipperOrder {
	
	private Terminal destinyTerminal;

	public ConsigneeOrder(String orderID, Client client, Container container, Truck truck, Driver driver, Travel travel) {
		super(orderID, client, container, truck, driver);
		this.travel = travel;
	}
	
	@Override
	public double getOrderPrice() {
        return super.getOrderPrice() + this.getTravelPrice();

    }

	private double getTravelPrice() {
		return travel.getTotalPriceUntilTerminal(destinyTerminal);
	}
	
	public Terminal getDestinyTerminal() {
		return destinyTerminal;
	}
}
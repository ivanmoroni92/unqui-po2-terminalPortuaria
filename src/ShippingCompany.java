import java.util.List;

public class ShippingCompany {
    // clase que modela a la shipping company
    // tiene una lista de rutas, una lista de ships
    // y un cronograma (schedule) que es una lista de viajes con las respecitas fechas de salida y el respectivo ship que la recorre.
    private String name;
    private List<ShippingRoute> shippingRoutes;
    private List<Travel> schedule;
    private List<Ship> ships;

    public ShippingCompany(String name, List<ShippingRoute> shippingRoutes, List<Travel> schedule, List<Ship> ships) {
        this.name = name;
        this.shippingRoutes = shippingRoutes;
        this.schedule = schedule;
        this.ships = ships;
    }

    public String getName() {
        return this.name;
    }

    public List<ShippingRoute> getShippingRoutes() {
        return this.shippingRoutes;
    }

    public List<Travel> getSchedule() {
        return this.schedule;
    }

    public List<Ship> getShips() {
        return this.ships;
    }

    public void addRoute(ShippingRoute route){
        this.shippingRoutes.add(route);
    }

    public void addShip(Ship ship){
        this.ships.add(ship);
    }

    public void addTravel(Travel travel){
        this.schedule.add(travel);
    }
}

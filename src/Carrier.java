import java.util.ArrayList;
import java.util.List;

public class Carrier {
	private String name ; 
	private List<Driver> drivers ;
	private List<Truck> trucks ;
	
	public Carrier(String name) {
		this.name = name ;
		this.drivers = new ArrayList<Driver>();
		this.trucks = new ArrayList<Truck>();
	}
	
	
	public String getName(){
		return name ;
	}
	
	
	public void addDriver(Driver diver) {
		drivers.add(diver);
	}
	
	public List<Driver> getDrivers(){
		return drivers ;
	}
	
	public boolean containsDriver(Driver driver) {
		return drivers.contains(driver);
	}
	
	
	public void addTruck(Truck truck) {
		trucks.add(truck);
	}
	
	public List<Truck> getTrucks(){
		return trucks ;
	}
	
	public boolean containsTruck(Truck truck) {
		return trucks.contains(truck);
	}
	

}

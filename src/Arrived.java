
public class Arrived implements State {
	
	public Arrived () {
		
	}

	@Override
	public void updateState(Ship ship, IManagedTerminal terminal) {
		State newState = new Working();
		System.out.println(" cambia a Working " );
		ship.setState(newState);
		
		
	}

	@Override
	public boolean distanceCondition(Ship ship) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void depart(Ship ship, IManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startWork(Ship ship, IManagedTerminal terminal) { 
		 System.out.println("Start of loading and unloading of containers");
		 this.updateState(ship, terminal);
		 
		
	}

}

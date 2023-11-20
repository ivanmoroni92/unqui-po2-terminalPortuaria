
public class Outbound implements State {
     
	public Outbound() {
		
	}

	@Override
	public void updateState(Ship ship, IManagedTerminal terminal) {
		State newState = new Inbound();
		ship.setState(newState);
		terminal.notifyConsignees();
	}

	@Override
	public boolean distanceCondition(Ship ship) {
	
		return ship.distanceToTerminale() < 50.0;
	}

	@Override
	public void depart(Ship ship, IManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startWork(Ship ship, IManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

}


public class Outbound implements IState {
     
	public Outbound() {
		
	}

	@Override
	public void updateState(Ship ship, ManagedTerminal terminal) {
		IState newState = new Inbound();
		ship.setState(newState);
		terminal.notifyConsignees();
	}

	@Override
	public boolean distanceCondition(Ship ship) {
	
		return ship.distanceToTerminale() < 50.0;
	}

	@Override
	public void depart(Ship ship, ManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startWork(Ship ship, ManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

}

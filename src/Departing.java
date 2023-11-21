
public class Departing  implements IState{

	@Override
	public void updateState(Ship ship, ManagedTerminal terminal) {
		 IState newState = new Outbound(); 
		 ship.setState(newState);
		 terminal.notifyShippers();
		 terminal.notifyClients();
		
	}

	@Override
	public boolean distanceCondition(Ship ship) {
		// TODO Auto-generated method stub
		return ship.distanceToTerminale() > 1.0;
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

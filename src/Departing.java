
public class Departing  implements State{

	@Override
	public void updateState(Ship ship, IManagedTerminal terminal) {
		 State newState = new Outbound(); 
		 ship.setState(newState);
		 terminal.sendMailShippers();
		
	}

	@Override
	public boolean distanceCondition(Ship ship) {
		// TODO Auto-generated method stub
		return ship.distanceToTerminale() > 1.0;
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

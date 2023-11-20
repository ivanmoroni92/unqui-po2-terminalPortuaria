
public class Inbound implements IState {
	
	
	public Inbound () {
		
	}

	@Override
	public void updateState(Ship ship, IManagedTerminal terminal) {
		System.out.println(" cambia a Arrived " );
		IState newState = new Arrived() ;
		ship.setState(newState);
		
	}

	@Override
	public boolean distanceCondition(Ship ship) {
		return ship.distanceToTerminale() == 0.0;
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

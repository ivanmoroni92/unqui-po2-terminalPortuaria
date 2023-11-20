
public class Working implements IState {
    
	public Working () {
		
	}
	@Override
	public void updateState(Ship ship, IManagedTerminal terminal) {
	  IState newState = new Departing();
	  ship.setState(newState);
	}

	@Override
	public boolean distanceCondition(Ship ship) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void depart(Ship ship, IManagedTerminal terminal) {
		 System.out.println("requesting departure");
		 this.updateState(ship, terminal);
		
	}

	@Override
	public void startWork(Ship ship, IManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

}

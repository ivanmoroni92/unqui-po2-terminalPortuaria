
public class Working implements IState {
    
	public Working () {
		
	}
	@Override
	public void updateState(Ship ship, ManagedTerminal terminal) {
	  IState newState = new Departing();
	  ship.setState(newState);
	}

	@Override
	public boolean distanceCondition(Ship ship) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void depart(Ship ship, ManagedTerminal terminal) {
		 System.out.println("requesting departure");
		 this.updateState(ship, terminal);
		
	}

	@Override
	public void startWork(Ship ship, ManagedTerminal terminal) {
		// TODO Auto-generated method stub
		
	}

}

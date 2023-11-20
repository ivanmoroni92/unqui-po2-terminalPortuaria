
public interface State {
	   void updateState(Ship ship, IManagedTerminal terminal);
	   boolean distanceCondition(Ship ship);
	   void depart(Ship ship, IManagedTerminal terminal);
	   void startWork(Ship ship, IManagedTerminal terminal);
}

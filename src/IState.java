
public interface IState {
	   void updateState(Ship ship, ManagedTerminal terminal);
	   boolean distanceCondition(Ship ship);
	   void depart(Ship ship, ManagedTerminal terminal);
	   void startWork(Ship ship, ManagedTerminal terminal);
}

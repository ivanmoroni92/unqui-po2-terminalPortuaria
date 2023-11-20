import java.awt.Point;

public interface  IManagedTerminal {
	Point getPoint() ;
	void notifyShippers();
	void notifyConsignees();
	String getName();
}

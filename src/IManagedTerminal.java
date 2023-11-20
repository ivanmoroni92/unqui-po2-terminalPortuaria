import java.awt.Point;

public interface  IManagedTerminal {
	Point getPoint() ;
	void sendMailconsignees();
	void sendMailShippers();
	String getName();
}

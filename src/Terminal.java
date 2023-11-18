import java.awt.Point;

public class Terminal {
	private String name;
	private Point position;
	
	public String getName() {
		return name;
	}
	
	public Point getPosition() {
		return position;
	}
	
	public Terminal(String name, Point position) {
		this.name = name;
		this.position = position;
	}
	
}

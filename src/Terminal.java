import java.awt.Point;

public class Terminal {
	private String name;
	private Point position;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public Terminal(String name, Point position) {
		super();
		this.name = name;
		this.position = position;
	}
	
}

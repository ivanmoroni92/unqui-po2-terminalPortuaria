import java.time.LocalDateTime;

public class Section {
	
	private Terminal startingTerminal;
	private Terminal endingTerminal;
	private Double price;
	private LocalDateTime time;
	
	public Terminal getStartingTerminal() {
		return startingTerminal;
	}
	public Terminal getEndingTerminal() {
		return endingTerminal;
	}
	public Double getPrice() {
		return price;
	}
	public LocalDateTime getTime() {
		return time;
	}
	
}

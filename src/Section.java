
public class Section {
	
	private Terminal startingTerminal;
	private Terminal endingTerminal;
	private Double price;
	private Integer time;
	
	public Terminal getStartingTerminal() {
		return startingTerminal;
	}
	public Terminal getEndingTerminal() {
		return endingTerminal;
	}
	public Double getPrice() {
		return price;
	}
	
	/**
	 * Este valor representa el tiempo que un buque demora un tramo desde la startingTerminal hasta la endingTerminal
	 * @return
	 */
	
	public Integer getTime() {
		return time;
	}
	
	//Constructor de la clase Section
	public Section(Terminal startingTerminal, Terminal endingTerminal, Double price, Integer time) {
		
		this.startingTerminal = startingTerminal;
		this.endingTerminal = endingTerminal;
		this.price = price;
		this.time = time;
	}
	
}


public class SearchByTerminal implements ISearchEngine {
	
	private String terminalName;
	
	
	public SearchByTerminal(String terminalName) {
		this.terminalName = terminalName;
	}
	
	@Override
	public boolean markedFilter(Travel travel) {
		return  travel.getRoute().getDestiny().getName() == terminalName;
	}
	
}

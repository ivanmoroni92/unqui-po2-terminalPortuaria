
public class SearchByTerminal implements ISearchEngine {
	
	private String terminalName;
	
	
	public SearchByTerminal(String terminalName) {
		this.terminalName = terminalName;
	}
	
	@Override
	public boolean markedFilter(Travel travel) {
	    String terminalNameTravel = travel.getRoute().getDestiny().getName();
		return terminalName.equals(terminalNameTravel);
	}
	
}

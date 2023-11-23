/**
 * La clase SearchByTerminal implementa la interfaz ISearchEngine y proporciona
 * un motor de búsqueda basado en el nombre de la terminal de destino.
 */
public class SearchByTerminal implements ISearchEngine {
	
	private String terminalName;
	
	 /**
     * Constructor que inicializa el objeto SearchByTerminal con el nombre de la terminal.
     * @param terminalName Nombre de la terminal a buscar.
     */
	public SearchByTerminal(String terminalName) {
		this.terminalName = terminalName;
	}
	
	 /**
     * Implementación del método markedFilter de la interfaz ISearchEngine.
     * Verifica si el nombre de la terminal de destino del viaje coincide con el nombre
     * de la terminal especificado en la instancia de SearchByTerminal.
     * @param travel Objeto Travel al que se aplicará el filtro de búsqueda.
     * @return true si el objeto Travel tiene como destino la terminal especificada, false en caso contrario.
     */
	@Override
	public boolean markedFilter(Travel travel) {
	    String terminalNameTravel = travel.getRoute().getDestiny().getName();
		return terminalName.equals(terminalNameTravel);
	}
	
}

import java.time.LocalDateTime;

/**
 * La clase abstracta SearchByDate proporciona una estructura base para implementar
 * filtros de búsqueda de viajes basados en fechas y criterios específicos.
 */

public abstract class SearchByDate implements ISearchEngine {
	
	protected LocalDateTime dateTosearch ;
	protected Criteria criteria ;
	
	
	  /**
     * Constructor que inicializa la fecha de búsqueda y el criterio.
     * @param date Fecha de búsqueda.
     * @param criteria Criterio de búsqueda (por ejemplo, mayor que, menor que, igual a).
     */

	public SearchByDate(LocalDateTime date, Criteria criteria) {
		this.dateTosearch = date ;	
		this.criteria = criteria ;
	}
	
    /**
     * Método protegido para obtener la fecha de búsqueda.
     * @return Fecha de búsqueda.
     */
	
	protected LocalDateTime getDate() {
		return dateTosearch;
	}
	
	 /**
     * Método abstracto que debe ser implementado por las subclases para aplicar
     * el filtro de búsqueda a un objeto Travel.
     * @param travel Objeto Travel al que se aplicará el filtro de búsqueda.
     * @return true si el objeto Travel cumple con el criterio de búsqueda, false en caso contrario.
     */
	public abstract boolean markedFilter(Travel travel);
	
	   /**
     * Método para realizar la búsqueda de fechas basada en el criterio proporcionado.
     * @param travelDate Fecha del viaje a comparar.
     * @return true si la fecha del viaje cumple con el criterio, false en caso contrario.
     */
	public boolean searchDateByCriteria(LocalDateTime travelDate) {
		switch (this.criteria) {
          case GREATHERTHAN:
              return this.searchGreatherThan(travelDate) ;
          case LESSTHAN:
        	  return this.searchLessThan(travelDate) ; 	  
          default:
        	  return this.searchEquals(travelDate) ;
      }
	}
	
	
	
	 /**
     * Método para realizar la búsqueda de fechas con el criterio "mayor que".
     * @param travelDate Fecha del viaje a comparar.
     * @return true si la fecha del viaje es posterior a la fecha de búsqueda, false en caso contrario.
     */
	private boolean searchGreatherThan(LocalDateTime travelDate) {
		
		return  travelDate.isAfter(this.dateTosearch);
	}
	
	
	 /**
     * Método para realizar la búsqueda de fechas con el criterio "menor que".
     * @param travelDate Fecha del viaje a comparar.
     * @return true si la fecha del viaje es anterior a la fecha de búsqueda, false en caso contrario.
     */
	private boolean searchLessThan(LocalDateTime travelDate) {
		
		return  travelDate.isBefore(this.dateTosearch);
	}
	
	  /**
     * Método para realizar la búsqueda de fechas con el criterio "igual a".
     * @param travelDate Fecha del viaje a comparar.
     * @return true si la fecha del viaje es igual a la fecha de búsqueda, false en caso contrario.
     */
	private boolean searchEquals(LocalDateTime travelDate) {
		
		return  travelDate.isEqual(this.dateTosearch);
	}
	
	
	
}

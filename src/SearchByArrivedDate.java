import java.time.LocalDateTime;
/**
 * La clase SearchByArrivedDate extiende la clase abstracta SearchByDate y
 * proporciona un filtro de búsqueda basado en la fecha de llegada de un viaje
 * a una terminal específica.
 */

public class SearchByArrivedDate extends SearchByDate {
	
	private Terminal destiny ;
	
	  /**
     * Constructor que inicializa la instancia de SearchByArrivedDate con la fecha,
     * criterio de búsqueda y la terminal de destino.
     * @param date Fecha de llegada para la búsqueda.
     * @param criteria Criterio de búsqueda (mayor que, menor que, igual a).
     * @param destiny Terminal de destino para la búsqueda.
     */
	public SearchByArrivedDate(LocalDateTime date, Criteria criteria, Terminal destiny) {
		super(date, criteria) ;
		this.destiny =destiny ;
	}

	@Override
    /**
     * Implementación del método markedFilter heredado de la clase SearchByDate.
     * Verifica si la fecha de llegada del viaje a la terminal específica
     * cumple con el criterio y la fecha especificada en la instancia de SearchByArrivedDate.
     * @param travel Objeto Travel al que se aplicará el filtro de búsqueda.
     * @return true si la fecha de llegada del viaje cumple con el criterio de búsqueda, false en caso contrario.
     */

	public boolean markedFilter(Travel travel) {
		return this.searchDateByCriteria(travel.getArrivalDate(destiny));
	}
	


}

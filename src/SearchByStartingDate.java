import java.time.LocalDateTime;
/**
 * La clase SearchByStartingDate extiende la clase abstracta SearchByDate y
 * proporciona un filtro de búsqueda basado en la fecha de inicio de un viaje.
 */
public class SearchByStartingDate extends SearchByDate {
	
	/**
     * Constructor que inicializa la instancia de SearchByStartingDate con la fecha y criterio de búsqueda.
     * @param date Fecha de inicio para la búsqueda.
     * @param criteria Criterio de búsqueda (mayor que, menor que, igual a).
     */
	public SearchByStartingDate(LocalDateTime date, Criteria criteria) {
		super(date, criteria);
		
	}
	
	  /**
     * Implementación del método markedFilter heredado de la clase SearchByDate.
     * Verifica si la fecha de inicio del viaje coincide con el criterio y la fecha
     * especificada en la instancia de SearchByStartingDate.
     * @param travel Objeto Travel al que se aplicará el filtro de búsqueda.
     * @return true si la fecha de inicio del viaje cumple con el criterio de búsqueda, false en caso contrario.
     */
	@Override
	public boolean markedFilter(Travel travel) {
		return this.searchDateByCriteria(travel.getStartingDate());
	}

}

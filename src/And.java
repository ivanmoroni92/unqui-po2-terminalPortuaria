/**
 * Clase que representa un operador lógico AND en una búsqueda.
 */
public class And extends Operator {
	
    /**
     * Constructor que recibe las condiciones primaria y secundaria.
     * @param primaryCondition La condición primaria a evaluar.
     * @param secondaryCondition La condición secundaria a evaluar.
     */

	public And(ISearchEngine primaryCondition, ISearchEngine secondaryCondition) {
		super(primaryCondition, secondaryCondition);
		
	}
	
	  /**
     * Implementación del método para evaluar el operador AND.
     * Devuelve true si ambas condiciones son verdaderas para un viaje dado.
     * @param travel El viaje a ser evaluado.
     * @return true si el viaje cumple con la condición del operador AND, false en caso contrario.
     */

	@Override
	public boolean markedFilter(Travel travel) {
		return this.primaryCondition.markedFilter(travel) && this.secondaryCondition.markedFilter(travel) ;
	}

}

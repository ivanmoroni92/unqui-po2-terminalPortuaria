/**
 * Clase que representa un operador lógico OR en una búsqueda.
 */
public class Or extends Operator {
    /**
     * Constructor que recibe las condiciones primaria y secundaria.
     * @param primaryCondition La condición primaria a evaluar.
     * @param secondaryCondition La condición secundaria a evaluar.
     */
	public Or(ISearchEngine primaryCondition, ISearchEngine secondaryCondition) {
		super(primaryCondition, secondaryCondition);


	}
	   /**
     * Implementación del método para evaluar el operador OR.
     * Devuelve true si al menos una de las condiciones es verdadera para un viaje dado.
     * @param travel El viaje a ser evaluado.
     * @return true si el viaje cumple con la condición del operador OR, false en caso contrario.
     */
	@Override
	public boolean markedFilter(Travel travel) {
		return this.primaryCondition.markedFilter(travel) || this.secondaryCondition.markedFilter(travel) ;
	}

}

/**
 * Clase abstracta que representa un operador en una búsqueda.
 * Implementa la interfaz ISearchEngine, que define el comportamiento básico de un motor de búsqueda.
 */
public abstract class Operator implements ISearchEngine {
	protected ISearchEngine primaryCondition ;
	protected ISearchEngine secondaryCondition ;
	
	 /**
     * Constructor que recibe las condiciones primaria y secundaria.
     * @param primaryCondition La condición primaria a evaluar.
     * @param secondaryCondition La condición secundaria a evaluar.
     */
	
    public Operator(ISearchEngine primaryCondition,ISearchEngine secondaryCondition) {
    	this.primaryCondition = primaryCondition ; 
    	this.secondaryCondition = secondaryCondition ;
    }
    
    /**
     * Método abstracto que debe ser implementado por las clases concretas.
     * Define la lógica específica del operador en términos de filtrado de viajes.
     * @param travel El viaje a ser evaluado.
     * @return true si el viaje cumple con la condición del operador, false en caso contrario.
     */

	@Override
	public abstract boolean markedFilter(Travel travel);

}

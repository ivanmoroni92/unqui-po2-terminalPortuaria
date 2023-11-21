import java.awt.Point;
/**
 * La clase Ship implementa el patrón de diseño State, y su comportamiento varía según los siguientes estados:
 *
 * Outbound:
 * Representa la fase inicial, indicando que el buque se encuentra lejos de la terminal.
 * Cambia de estado a Inbound cuando el Ship está a menos de 50 km de distancia de la terminal.y la terminal 
 * envía un correo a todos los consignees que esperan este buque.
 *
 * Inbound:
 * El buque notifica a la terminal sobre su inminente llegada, 
 * Cambia de estado a Arrived cuando el buque llega a la terminal.
 *
 * Arrived:
 * El Ship espera la orden de inicio de trabajo por parte de la terminal.
 * Cambia de estado a Working cuando la terminal ejecuta el método startWork del estado.
 *
 * Working:
 * Indica que el trabajo de carga y descarga está en curso.
 * Cambia de estado a Departing hasta que se ejecuta el método depart del estado.
 *
 * Departing:
 * El buque está saliendo de la terminal.
 * Cambia de estado cuando la distancia a la terminal es mayor a 1 km, y el buque vuelve a la fase de Outbound.
 * La terminal envía un correo electrónico a todos los shippers cuyas órdenes de exportación están asociadas a ese viaje,
 * informándoles que su carga ha salido de la terminal.
 */


public class Ship {
	
	
	
	private String id ;
	private Point position ; 
	private ManagedTerminal origen ;
	private IState state ;

	 /**
     * Constructor de la clase Ship.
     *
     * @param id      Identificador único del buque.
     * @param position Posición actual del buque.
     * @param state   Estado inicial del buque.
     * @param origen  Terminal de origen del buque.
     */
	
	public Ship(String id,Point position,IState state,ManagedTerminal origen ){
		this.id = id ;
		this.state = state;
		this.origen = origen ;
		this.position = position ;
		
	}
	
	public ManagedTerminal getOrigen() {
		return origen;
	}
	
	public String getId() {
		return this.id;
	}
	
	

    public IState getState() {
			return  state ;
			
	}
    
	/**
	 * Establece el estado actual del buque.
	 *
	 * @param state Nuevo estado del buque.
	 */
	public void setState(IState state) {
			this.state = state ;
			
	}
    
	
	
	/**
    * Calcula la distancia entre la posición actual del buque y la terminal.
    *
    * @return Distancia entre la posición actual y la terminal.
    *
    */
    public  double distanceToTerminale() {
    	double distanceX = origen.getPosition().x - this.getPosition().x;
    	double distanceY = origen.getPosition().y - this.getPosition().y ;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }


	public Point getPosition() {
		return position;
	}
	
	
    /**
     * Establece la posición actual del buque y actualiza el estado si se cumple la condición de distancia.
     * 
     *
     * @param position Nueva posición del buque.
    */
	public void setPosition(Point position) {
		this.position = position;
	   if( this.state.distanceCondition(this) ) {
			this.state.updateState(this,origen);
		}
		
	}
	
	
	 /**
     * Mensaje de partida del Ship, solo funciona en el estado Working.
     */
	public void depart() {
		this.state.depart(this, origen);
		
	}

	 /**
     * Mensaje de inicio de trabajo de carga y descarga, solo funciona en el estado Arrived.
     */
	public void startWork() {
		this.state.startWork(this, origen);
		
	}


}

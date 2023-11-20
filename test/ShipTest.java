import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Point;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ShipTest {
	
	private Ship ship ;
	private Point startPoint ;
	private Point terminalPoint ;
	@Mock private IManagedTerminal terminal ;
	private State outbound ;
	private State Inbound  ;
	private State working ;
	private State Arrived ;
	private State departing ;

	
	

	

	@BeforeEach
	void setUp() throws Exception {
		outbound = new Outbound();
		terminal = mock(IManagedTerminal.class);
		startPoint = new Point(50, 0);
		ship = new Ship("A-100", startPoint,outbound,terminal) ;
		}
	
	


	
	
	

	@Test
	void testShipId() {
		assertEquals("A-100", ship.getId());
	}
	
	
	@Test
	void testGetPosition() {
		assertEquals(startPoint, ship.getPosition());
	}
	
	@Test
	void testStartState() {
		assertEquals(outbound, ship.getState());		
	}
	
	
	@Test
	void testSetState() {
		Inbound  = new Inbound(); 
		ship.setState(Inbound) ; 
		assertEquals(Inbound, ship.getState());		
	}
	
	
	
	@Test
	void testSetPosition() {
		// Cambia de posicion al Ship
		// mokeo la posicion de la terminal por que la necesito
        //para el mensaje distanceCondition dentro del setPosition.
		terminalPoint = new Point(0, 0);
		when(terminal.getPoint()).thenReturn(terminalPoint);
		Point  shipPoint = new Point(60,45);
	    ship.setPosition(shipPoint); 
		assertEquals(shipPoint, ship.getPosition());
	
	}
	
	
	
	
	
	@Test
	void testDistanceToTerminal50KM() {
		//La terminal se encuentra a una distancia de 50 km. En este caso,
		//el buque no experimenta un cambio de estado, ya que la distancia no cumple con 
		//las condiciones necesarias.
		//Como resultado,no se emite una notificación a los consignatarios en esta situación.
		terminalPoint = new Point(0, 0);
		when(terminal.getPoint()).thenReturn(terminalPoint);
		Point  shipPoint = new Point(50,0);
	    ship.setPosition(shipPoint); 
		assertEquals(50.0, ship.distanceToTerminale());
		verify(terminal,times(4)).getPoint();
		verify(terminal, times(0)).notifyConsignees();
	}
	
	
	@Test
	void testDistanceToTerminaLessThan50() {
		//  La terminal se encuentra a una distancia de 50 km mientras el buque está en el estado Outbound.
		//Cuando la distancia es inferior a 50 km, el buque experimenta un cambio de estado y envía un mensaje a
		//los consignatarios para notificarles.
	   
		terminalPoint = new Point(50, 50);
		when(terminal.getPoint()).thenReturn(terminalPoint);
		Point  shipPoint = new Point(40,35);
	    ship.setPosition(shipPoint); 
		assertEquals(shipPoint, ship.getPosition());
		assertNotEquals(outbound, ship.getState());
		verify(terminal, times(1)).notifyConsignees();
	
	}
	
	@Test
	void testShipAtTheTerminal() {
		// terminal se encuentra a 0km de distancia.
		terminalPoint = new Point(85, 95);
		when(terminal.getPoint()).thenReturn(terminalPoint);
		Point  shipPoint = new Point(85, 95);
	    ship.setPosition(shipPoint); 
		
		assertEquals(0, ship.distanceToTerminale());
		verify(terminal,times(4)).getPoint(); 
	}
	
	@Test
	void testShipMovesMoreThan1kmAway() {
		// la terminal se encuentra en estado Departing a una distancia mayor  a 1km de la teminal.
		//por lo que el Ship cambia de estado  y envía un mensaje a los Shippers para notificarles.
		departing = new Departing();
		ship.setState(departing);
		terminalPoint = new Point(40, 35);
		when(terminal.getPoint()).thenReturn(terminalPoint);
		Point  shipPoint = new Point(42, 35);
	    ship.setPosition(shipPoint); 
		
		assertEquals(2.0, ship.distanceToTerminale());
		assertNotEquals(departing, ship.getState());
		verify(terminal,times(1)).notifyShippers();
		
		
	}
	
	
	@Test
	void testGetOrigin() {
		when(terminal.getName()).thenReturn("Buenos Aires");
		assertEquals("Buenos Aires", ship.getOrigen().getName());
		verify(terminal,times(1)).getName();
		
	}
	
	@Test
	void testStartWork() {
		// la terminal se encuentra en estado Arrived pero cuando se ejecuta el mensaje 
		// startWork pasa al estado Working.
		Arrived  = new Arrived(); 
		ship.setState(Arrived) ; 
		ship.startWork(); 
		assertNotEquals(Arrived,ship.getState() );		
	}
	
	
	
	@Test
	void testDepart() {
		// la terminal se encuentra en estado Working pero cuando se ejecuta el mensaje 
		// depert pasa al estado Departing.
		working  = new Working(); 
		ship.setState(working) ; 
		ship.depart(); 
		assertNotEquals(working,ship.getState() );		
	}
	
	
	
	
	
	
	
	
	

}

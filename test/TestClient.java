import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestClient {
	
	private Client cliente ;

	@BeforeEach
	void setUp() throws Exception {
		cliente = new Client("Ivan" , "ivancito@gmail.com");
	}

	@Test
	void getNameClient() {
		assertEquals("Ivan", cliente.getName()  );
	}

	@Test
	void getEmailClient() {
		assertEquals("ivancito@gmail.com", cliente.getMail() );
	}

}

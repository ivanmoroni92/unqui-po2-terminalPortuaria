import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testAppointmentOk() {
        LocalDateTime date = LocalDateTime.of(2023, 11, 23, 10, 0);
        IOrder mockOrder = mock(IOrder.class);

        Appointment appointment = new Appointment(date, mockOrder);

        // Assert
        assertEquals(date, appointment.getDateAndTime());
        assertEquals(mockOrder, appointment.getOrder());
    }
}

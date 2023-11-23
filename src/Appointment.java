import java.time.LocalDateTime;

public class Appointment {

    // es el "turno" que le da la terminal al cliente, tiene la fecha de la cita junto con la orden.
    private LocalDateTime dateAndTime;
    private IOrder order;

    public Appointment(LocalDateTime dateAndTime, IOrder order) {
        this.dateAndTime = dateAndTime;
        this.order = order;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public IOrder getOrder() {
        return order;
    }
}
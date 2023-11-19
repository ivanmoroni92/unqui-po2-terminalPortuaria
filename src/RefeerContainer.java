public class RefeerContainer extends Container{
    private double consumePerHour;

    public RefeerContainer(double width, double length, double heigth, double weigth, double consumePerHour) {
        super(width, length, heigth, weigth);
        this.consumePerHour = consumePerHour;
    }

    public double getConsumePerHour() {
        return consumePerHour;
    }
}

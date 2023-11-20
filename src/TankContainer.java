public class TankContainer extends Container {
    public TankContainer(double width, double length, double heigth, double weigth) {
        super(width, length, heigth, weigth);
    }

	@Override
	public double getConsumePerHour() {
		return 0;
	}
}
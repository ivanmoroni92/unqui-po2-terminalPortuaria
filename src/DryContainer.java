public class DryContainer extends Container {
    public DryContainer(double width, double length, double heigth, double weigth) {
        super(width, length, heigth, weigth);
    }

	@Override
	public double getConsumePerHour() {
		return 0;
	}
}

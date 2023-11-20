public abstract class Container {
    private double width;
    private double length;
    private double heigth;
    private double weigth;

    public Container(double width, double length, double heigth, double weigth) {
        this.width = width;
        this.length = length;
        this.heigth = heigth;
        this.weigth = weigth;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWeigth() {
        return weigth;
    }

    public double getVolume(){
        return this.heigth * this.length * this.width;
    }
    
    public abstract double getConsumePerHour();
}

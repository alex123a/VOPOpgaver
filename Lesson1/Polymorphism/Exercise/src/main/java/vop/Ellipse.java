package vop;

public class Ellipse extends AbstractShape {
    protected double r1;
    protected double r2;

    public Ellipse(double r1, double r2) {
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public double getArea() {
        return Math.PI * this.r1 * this.r2;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * Math.sqrt(0.5 * (Math.pow(this.r1, 2) + Math.pow(this.r2, 2)));
    }
}

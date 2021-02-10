package vop;

public class Rectangle extends AbstractShape {
    protected double l1;
    protected double l2;

    public Rectangle(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double getArea() {
        return this.l1 * this.l2;
    }

    @Override
    public double getCircumference() {
        return this.l1 * 2 + this.l2 * 2;
    }
}

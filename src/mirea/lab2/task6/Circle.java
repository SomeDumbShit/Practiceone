package mirea.lab2.task6;


public class Circle {
    private double x;
    private double y;
    private double r;

    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getArea() {
        return Math.PI * r * r;
    }

    public double getLength() {
        return 2 * Math.PI * r;
    }

    //  1 - эта окружность больше, -1 - меньше, 0 - одинаковые
    public int compare(Circle other) {
        if (this.r > other.r) {
            return 1;
        } else if (this.r < other.r) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Circle{x=" + x + ", y=" + y + ", r=" + r + "}";
    }
}

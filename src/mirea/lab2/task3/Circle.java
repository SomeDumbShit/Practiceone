package mirea.lab2.task3;

public class Circle {
    private Point center;   // центр окружность
    private double radius;
    private String colour;

    // Центр передаём готовой точкой
    public Circle(Point center, double radius, String colour) {
        this.center = center;
        this.radius = radius;
        this.colour = colour;
    }

    // Центр задаём числами x и y
    public Circle(double x, double y, double radius, String colour) {
        this.center = new Point(x, y);
        this.radius = radius;
        this.colour = colour;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Circle{центр=" + center + ", r=" + radius + ", цвет=" + colour + "}";
    }
}
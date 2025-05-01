package pl.pp;

public class Circle {

    private double radius; // Make the radius private

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public void getInfo() {
        System.out.println("Circle with radius = " + radius + ", area = " + area() + " and circumference = " + circumference());
    }
}

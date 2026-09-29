package mirea.lab2.task4;

// Класс Computer - один компьютер в магазине
public class Computer {
    private String brand;
    private String model;
    private double price;
    private int ram;

    public Computer(String brand, String model, double price, int ram) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.ram = ram;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }
}

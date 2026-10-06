package mirea.lab6;

public class CelsiusToFahrenheit implements Convertable {
    @Override
    public double convert(double value) {
        return value * 9 / 5 + 32;                 // F = C * 9 / 5 + 32
    }
}

package mirea.lab6;

public class CelsiusToKelvin implements Convertable {
    @Override
    public double convert(double value) {
        return value + 273.15;                     // K = C + 273.15
    }
}

package mirea.lab7.task4;

public class MathFunc implements MathCalculable {

    @Override
    public double pow(double base, double exponent) {
        return Math.pow(base, exponent);           // готовый метод из класса Math
    }

    @Override
    public double complexModule(double re, double im) {
        return Math.sqrt(re * re + im * im);       // модуль = корень из суммы квадратов
    }

    // свой метод класса: длина окружности, число PI берем из интерфейса
    public double circleLength(double r) {
        return 2 * PI * r;
    }
}

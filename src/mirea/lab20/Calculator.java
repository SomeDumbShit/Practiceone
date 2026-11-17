package mirea.lab20;

// задание 4: сам класс необобщенный, обобщенные только его статические методы
public class Calculator {

    // два числа РАЗНЫХ типов (Integer, Double, Long ...): T и V - любые наследники Number
    public static <T extends Number, V extends Number> double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, V extends Number> double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T a, V b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtraction(T a, V b) {
        return a.doubleValue() - b.doubleValue();
    }
}

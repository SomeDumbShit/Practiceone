package mirea.lab18;

public class Exception1 {

    // задание 1, шаг 1: деление целых чисел на ноль, исключение нигде не перехватывается
    public void exceptionDemoStep1() {
        System.out.println(2 / 0);                 // целочисленное деление на 0: ArithmeticException
    }

    // задание 1, шаг 2: деление вещественных чисел на ноль, исключения нет
    public void exceptionDemoStep2() {
        System.out.println(2.0 / 0.0);             // результат Infinity (бесконечность), программа не падает
    }

    // задание 1, шаги 2-3: то же деление на ноль, но с блоком try-catch
    public void exceptionDemo() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {          // перехватываем именно деление на ноль
            System.out.println("Attempted division by zero");
        }
    }
}

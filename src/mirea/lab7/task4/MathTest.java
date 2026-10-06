package mirea.lab7.task4;

public class MathTest {
    public static void main(String[] args) {
        MathCalculable mc1 = new MathFunc();       // правильно: переменная интерфейса, объект класса
        // MathCalculable mc2 = new MathCalculable();   // ошибка: объект интерфейса создавать нельзя

        System.out.println("PI из интерфейса = " + MathCalculable.PI);
        System.out.println("2 в степени 10 = " + mc1.pow(2, 10));
        System.out.println("Модуль 3 + 4i = " + mc1.complexModule(3, 4));

        MathFunc f = new MathFunc();               // circleLength есть только в классе, поэтому тип MathFunc
        System.out.printf("Длина окружности при r = 5: %.2f%n", f.circleLength(5));
    }
}

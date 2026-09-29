package mirea.lab2.task6;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(0, 0, 2);
        Circle c2 = new Circle(1, 1, 5);

        System.out.println(c1);
        System.out.println("Площадь c1 = " + c1.getArea());
        System.out.println("Длина c1 = " + c1.getLength());

        System.out.println(c2);
        System.out.println("Площадь c2 = " + c2.getArea());
        System.out.println("Длина c2 = " + c2.getLength());

        int result = c1.compare(c2);
        if (result > 0) {
            System.out.println("c1 больше c2");
        } else if (result < 0) {
            System.out.println("c1 меньше c2");
        } else {
            System.out.println("Окружности равны");
        }

        c1.setR(5);   // меняем радиус
        System.out.println("После setR(5): сравнение = " + c1.compare(c2));
    }
}

package mirea.lab2.task2;

// Проверяем класс Ball
public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball();          // мяч в точке (0.0; 0.0)
        Ball b2 = new Ball(3.5, 4.0);  // мяч в точке (3.5; 4.0)

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);

        b1.setX(1.0);
        b1.setY(2.0);
        System.out.println("После setX/setY: " + b1);

        b1.setXY(10, 20);
        System.out.println("После setXY(10, 20): " + b1);

        b1.move(5, -3);   // сдвигаем вправо на 5 и вниз на 3
        System.out.println("После move(5, -3): " + b1);

        System.out.println("x = " + b1.getX() + ", y = " + b1.getY());
    }
}

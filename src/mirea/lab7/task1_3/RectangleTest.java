package mirea.lab7.task1_3;

public class RectangleTest {
    public static void main(String[] args) {
        MovableRectangle r = new MovableRectangle(1, 1, 5, 4, 2, 3);   // скорость (2, 3)
        System.out.println("Начало:      " + r);
        System.out.println("Скорости точек одинаковые: " + r.SpeedTest());

        r.moveRight();                             // x у обеих точек увеличился на 2
        System.out.println("moveRight:   " + r);
        r.moveDown();                              // y у обеих точек увеличился на 3
        System.out.println("moveDown:    " + r);

        Movable m = r;                             // ссылка типа интерфейса на тот же объект
        m.moveLeft();
        System.out.println("moveLeft:    " + m);
        m.moveUp();
        System.out.println("moveUp:      " + m);

        // прямоугольник из двух готовых точек с разной скоростью
        MovablePoint p1 = new MovablePoint(0, 0, 1, 1);
        MovablePoint p2 = new MovablePoint(4, 4, 2, 2);
        MovableRectangle r2 = new MovableRectangle(p1, p2);
        System.out.println("Скорости точек одинаковые: " + r2.SpeedTest());
    }
}

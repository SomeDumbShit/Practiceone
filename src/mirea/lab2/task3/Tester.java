package mirea.lab2.task3;


// Класс Tester хранит массив окружностей и количество окружностей в нём
public class Tester {
    private Circle[] circles;
    private int count;

    public Tester(int size) {
        circles = new Circle[size];  // создаём массив нужного размера (пока в нём null)
        count = 0;
    }

    // Добавить окружность в массив
    public void add(Circle circle) {
        if (count < circles.length) {
            circles[count] = circle;
            count++;
        } else {
            System.out.println("Массив заполнен!");
        }
    }

    // Вывести все окружности
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ") " + circles[i]);
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Tester tester = new Tester(5);

        Point p = new Point(1, 2);
        tester.add(new Circle(p, 3.0, "red"));
        tester.add(new Circle(0, 0, 1.5, "blue"));
        tester.add(new Circle(-2, 4, 10, "green"));

        tester.printAll();
        System.out.println("Всего окружностей: " + tester.getCount());
    }
}

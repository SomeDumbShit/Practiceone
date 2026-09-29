package mirea.lab2.task4;

// Класс Shop - магазин компьютеров.
// Внутри хранится массив компьютеров и их количество.
public class Shop {
    private Computer[] computers;
    private int count;

    public Shop(int capacity) {
        computers = new Computer[capacity];
        count = 0;
    }

    // Добавить компьютер
    public void addComputer(Computer computer) {
        if (count == computers.length) {
            System.out.println("В магазине нет места!");
            return;
        }
        computers[count] = computer;
        count++;
        System.out.println("Компьютер добавлен.");
    }

    // Удалить компьютер по модели. Возвращает true, если удалили
    public boolean removeComputer(String model) {
        for (int i = 0; i < count; i++) {
            if (computers[i].getModel().equalsIgnoreCase(model)) {
                // Сдвигаем все следующие элементы на одну позицию влево
                for (int j = i; j < count - 1; j++) {
                    computers[j] = computers[j + 1];
                }
                computers[count - 1] = null;  // последнюю ячейку очищаем
                count--;
                return true;
            }
        }
        return false;  // не нашли
    }

    // Найти компьютер по модели. Если не нашли - вернём null (то есть "ничего")
    public Computer findComputer(String model) {
        for (int i = 0; i < count; i++) {
            if (computers[i].getModel().equalsIgnoreCase(model)) {
                return computers[i];
            }
        }
        return null;
    }

    // Показать все компьютеры
    public void printAll() {
        if (count == 0) {
            System.out.println("В магазине пока нет компьютеров.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ") " + computers[i]);
        }
    }
}

package mirea.lab20;

// задание 4: поиск минимального и максимального элемента массива любого сравнимого типа
public class MinMax<T extends Comparable<T>> {
    private final T[] array;                       // массив - переменная класса, приходит через конструктор

    public MinMax(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }
        this.array = array;
    }

    public T min() {
        T result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(result) < 0) {  // текущий элемент меньше найденного минимума
                result = array[i];
            }
        }
        return result;
    }

    public T max() {
        T result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(result) > 0) {
                result = array[i];
            }
        }
        return result;
    }
}

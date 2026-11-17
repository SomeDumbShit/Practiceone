package mirea.lab21;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    // задание 1: массив любого ссылочного типа (String[], Integer[] ...) в список
    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            list.add(element);
        }
        return list;
    }

    // для массива примитивов: дженерики работают только с объектами, поэтому отдельный метод
    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int element : array) {
            list.add(element);                     // автоупаковка int в Integer
        }
        return list;
    }

    // задание 3: элемент массива любого типа по индексу
    public static <T> T getElement(T[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + array.length);
        }
        return array[index];
    }
}

package mirea.lab21;

import java.util.Arrays;

// задание 2: хранит массив любого ссылочного типа; для int, long и других примитивов есть фабричные методы
public class ArrayStore<T> {
    private final T[] array;

    public ArrayStore(T[] array) {
        this.array = array;
    }

    // из int[] делаем Integer[]: примитив нельзя подставить вместо T
    public static ArrayStore<Integer> ofInts(int[] values) {
        Integer[] boxed = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            boxed[i] = values[i];                  // автоупаковка
        }
        return new ArrayStore<>(boxed);
    }

    public static ArrayStore<Long> ofLongs(long[] values) {
        Long[] boxed = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
            boxed[i] = values[i];
        }
        return new ArrayStore<>(boxed);
    }

    // задание 3: элемент по индексу
    public T get(int index) {
        return ArrayUtils.getElement(array, index);
    }

    public int size() {
        return array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}

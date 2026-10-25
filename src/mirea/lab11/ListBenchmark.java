package mirea.lab11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListBenchmark {

    // добавление n элементов в конец списка, возвращает время в наносекундах
    private static long testAdd(List<Integer> list, int n) {
        long start = System.nanoTime();            // засекаем время начала
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;          // прошедшее время
    }

    // 1000 поисков значения, которого нет в списке (приходится просмотреть весь список)
    private static long testSearch(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.contains(-1);
        }
        return System.nanoTime() - start;
    }

    // удаление n элементов из начала списка
    private static long testRemove(List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.remove(0);                        // remove(0) удаляет элемент с индексом 0
        }
        return System.nanoTime() - start;
    }

    // вставка n элементов в начало списка
    private static long testInsert(List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            list.add(0, i);                        // add(0, i) вставляет i на позицию 0
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        int n = 50000;                             // размер списка
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // порядок важен: сначала заполняем, потом ищем, потом удаляем, потом вставляем в пустой список
        long arrayAdd = testAdd(arrayList, n);
        long linkedAdd = testAdd(linkedList, n);
        long arraySearch = testSearch(arrayList);
        long linkedSearch = testSearch(linkedList);
        long arrayRemove = testRemove(arrayList, n);
        long linkedRemove = testRemove(linkedList, n);
        long arrayInsert = testInsert(arrayList, n);
        long linkedInsert = testInsert(linkedList, n);

        System.out.println("Время в миллисекундах, элементов: " + n);
        System.out.printf("%-28s %12s %12s%n", "Операция", "ArrayList", "LinkedList");
        System.out.printf("%-28s %12.2f %12.2f%n", "Добавление в конец", arrayAdd / 1e6, linkedAdd / 1e6);
        System.out.printf("%-28s %12.2f %12.2f%n", "Поиск (1000 раз)", arraySearch / 1e6, linkedSearch / 1e6);
        System.out.printf("%-28s %12.2f %12.2f%n", "Удаление из начала", arrayRemove / 1e6, linkedRemove / 1e6);
        System.out.printf("%-28s %12.2f %12.2f%n", "Вставка в начало", arrayInsert / 1e6, linkedInsert / 1e6);
    }
}

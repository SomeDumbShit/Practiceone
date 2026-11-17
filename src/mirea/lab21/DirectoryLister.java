package mirea.lab21;

import java.io.File;
import java.util.Arrays;
import java.util.List;

// задание 4: содержимое каталога в список и вывод первых 5 элементов
public class DirectoryLister {

    // сохраняет имена файлов и папок каталога в список (по алфавиту)
    public static List<String> readDirectory(String path) {
        String[] names = new File(path).list();    // null, если это не каталог или к нему нет доступа
        if (names == null) {
            throw new IllegalArgumentException("Не каталог или нет доступа: " + path);
        }
        Arrays.sort(names);
        return ArrayUtils.toList(names);           // используем метод из задания 1
    }

    // выводит первые count элементов списка любого типа (List<?> - подстановочный знак)
    public static void printFirst(List<?> list, int count) {
        int n = Math.min(count, list.size());      // в списке может быть меньше элементов, чем нужно
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public static void printFirstFive(String path) {
        List<String> list = readDirectory(path);
        System.out.println("Всего элементов в каталоге: " + list.size());
        printFirst(list, 5);
    }
}

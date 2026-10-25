package mirea.lab13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WordChain {

    // подходит ли слово next после слова prev: последняя буква prev равна первой букве next без учета регистра
    private static boolean fits(String prev, String next) {
        char last = Character.toLowerCase(prev.charAt(prev.length() - 1));
        char first = Character.toLowerCase(next.charAt(0));
        return last == first;
    }

    // перебор с возвратом: пытается поставить слово на место count, если не получается, откатывает выбор
    private static boolean build(String[] words, boolean[] used, String[] chain, int count) {
        if (count == words.length) {               // базовый случай: все слова расставлены
            return true;
        }
        for (int i = 0; i < words.length; i++) {
            boolean ok = (count == 0);             // на первое место подходит любое слово
            if (count > 0) {
                ok = fits(chain[count - 1], words[i]);
            }
            if (!used[i] && ok) {                  // слово еще не использовано и подходит
                used[i] = true;
                chain[count] = words[i];
                if (build(words, used, chain, count + 1)) {   // пробуем расставить остальные
                    return true;
                }
                used[i] = false;                   // не получилось: откатываем и пробуем другое слово
            }
        }
        return false;
    }

    // слова можно передать списком через запятую или массивом (String... означает любое количество строк)
    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        String[] chain = new String[words.length];
        boolean[] used = new boolean[words.length];
        if (build(words, used, chain, 0)) {
            for (int i = 0; i < chain.length; i++) {
                if (i > 0) {
                    result.append(' ');            // пробел между словами
                }
                result.append(chain[i]);
            }
        }
        return result;                             // пустой, если цепочку составить нельзя
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine().trim();
        try {
            String text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8).trim();
            if (text.isEmpty()) {
                System.out.println("Файл пустой.");
                return;
            }
            String[] words = text.split("\\s+");   // режем текст на слова по любым пробелам и переводам строк
            StringBuilder line = getLine(words);
            if (line.length() == 0) {
                System.out.println("Цепочку составить нельзя.");
            } else {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл: " + fileName);
        }
    }
}

package mirea.lab2.task10;

import java.util.Scanner;

// Считаем, сколько слов ввёл пользователь
public class HowMany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        text = text.trim();   // убираем пробелы по краям

        int count;
        if (text.isEmpty()) {
            count = 0;        // ничего не ввели
        } else {
            // разрезаемс строку по одному или нескольким пробелам
            String[] words = text.split("\\s+");
            count = words.length;
        }

        System.out.println("Количество слов: " + count);
    }
}

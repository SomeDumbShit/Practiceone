package mirea.lab14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ExactString {
    public static void main(String[] args) {
        String regex = "abcdefghijklmnopqrstuv18340";   // обычные символы в шаблоне совпадают только сами с собой
        String[] tests = {"abcdefghijklmnopqrstuv18340", "abcdefghijklmnoasdfasdpqrstuv18340"};

        System.out.println("Примеры из задания:");
        for (int i = 0; i < tests.length; i++) {
            System.out.println(tests[i] + " -> " + Pattern.matches(regex, tests[i]));   // matches проверяет всю строку
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите свои строки (пустая строка завершает программу):");
        String line = scanner.nextLine();
        while (!line.isEmpty()) {
            System.out.println(Pattern.matches(regex, line));
            line = scanner.nextLine();
        }
    }
}

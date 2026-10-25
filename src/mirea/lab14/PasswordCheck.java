package mirea.lab14;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordCheck {
    public static void main(String[] args) {
        // (?=.*[A-Z]) есть заглавная, (?=.*[a-z]) есть строчная, (?=.*\d) есть цифра, \w{8,} только буквы, цифры, _ и от 8 символов
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)\\w{8,}";
        String[] tests = {"F032_Password", "TrySpy1", "smart_pass", "A007", "Qwerty123"};

        System.out.println("Проверка примеров:");
        for (int i = 0; i < tests.length; i++) {
            String answer = "ненадежный";
            if (Pattern.matches(regex, tests[i])) {
                answer = "надежный";
            }
            System.out.println(tests[i] + " -> " + answer);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите пароли (пустая строка завершает программу):");
        String line = scanner.nextLine();
        while (!line.isEmpty()) {
            if (Pattern.matches(regex, line)) {
                System.out.println("надежный");
            } else {
                System.out.println("ненадежный");
            }
            line = scanner.nextLine();
        }
    }
}

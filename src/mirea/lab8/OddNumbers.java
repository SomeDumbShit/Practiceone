package mirea.lab8;

import java.util.Scanner;

public class OddNumbers {


    public static void printOdd() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            return;
        }
        if (n % 2 != 0) {
            System.out.println(n);
        }
        printOdd();                                // шаг рекурсии: читаем следующее число
    }

    public static void main(String[] args) {
        printOdd();                                // по условию main только вызывает этот метод
    }
}

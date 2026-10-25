package mirea.lab8;

import java.util.Scanner;

public class ReverseNumber {

    // метод для вызова: принимает число и возвращает число, записанное цифрами в обратном порядке
    public static long reverse(long n) {
        return reverse(n, 0);                      // запускаем рекурсию, собранное число сначала равно 0
    }

    // рекурсивный метод: n это оставшиеся цифры, result это уже собранное число
    private static long reverse(long n, long result) {
        if (n == 0) {
            return result;
        }
        return reverse(n / 10, result * 10 + n % 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число без нулей: ");
        long n = scanner.nextLong();
        System.out.println("Число наоборот: " + reverse(n));
    }
}

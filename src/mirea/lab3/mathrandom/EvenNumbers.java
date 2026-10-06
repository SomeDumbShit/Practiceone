package mirea.lab3.mathrandom;

import java.util.Random;
import java.util.Scanner;

public class EvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // объект для ввода с клавиатуры
        int n = 0;

        while (n <= 0) {
            System.out.print("Введите размер массива (натуральное число): ");
            if (scanner.hasNextInt()) {            // проверяем, что ввели целое число
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Число должно быть больше нуля, повторите ввод.");
                }
            } else {
                System.out.println("Это не число, повторите ввод.");
                scanner.next();                    // убираем неверный ввод, иначе цикл будет бесконечным
            }
        }

        Random rand = new Random();
        int[] a = new int[n];
        System.out.print("Первый массив: ");
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n + 1);            // число от 0 до n включительно
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Четных элементов нет");
        } else {
            int[] even = new int[count];
            int k = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 == 0) {
                    even[k] = a[i];
                    k++;
                }
            }
            System.out.print("Четные элементы: ");
            for (int i = 0; i < even.length; i++) {
                System.out.print(even[i] + " ");
            }
            System.out.println();
        }
    }
}

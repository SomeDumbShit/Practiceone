package ru.mirea.lab1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int n = sc.nextInt();

        int[] numbers = new int[n]; // создаём массив нужного размера

        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int sumDoWhile = 0;
        int i = 0;
        do {
            sumDoWhile += numbers[i];
            i++;
        } while (i < n);

        int sumWhile = 0;
        int j = 0;
        while (j < n) {
            sumWhile += numbers[j];
            j++;
        }

        int max = numbers[0]; // начинаем с первого элемента
        int min = numbers[0];
        for (int k = 1; k < n; k++) {
            if (numbers[k] > max) {
                max = numbers[k];
            }
            if (numbers[k] < min) {
                min = numbers[k];
            }
        }

        System.out.println("Сумма (do while): " + sumDoWhile);
        System.out.println("Сумма (while): " + sumWhile);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);
    }
}

package mirea.lab3.mathrandom;

import java.util.Arrays;
import java.util.Random;

public class RandomArraySort {

    // печатает массив чисел с двумя знаками после запятой
    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%.2f ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        double[] a = new double[n];                // массив для первого способа (Math.random)
        double[] b = new double[n];                // массив для второго способа (класс Random)
        Random rand = new Random();                // создаем объект генератора случайных чисел

        for (int i = 0; i < n; i++) {
            a[i] = Math.random() * 100;
            b[i] = rand.nextDouble() * 100;
        }

        System.out.println("Способ 1: метод Math.random()");
        System.out.print("До сортировки:    ");
        printArray(a);
        Arrays.sort(a);
        System.out.print("После сортировки: ");
        printArray(a);

        System.out.println();
        System.out.println("Способ 2: класс Random");
        System.out.print("До сортировки:    ");
        printArray(b);
        Arrays.sort(b);
        System.out.print("После сортировки: ");
        printArray(b);
    }
}

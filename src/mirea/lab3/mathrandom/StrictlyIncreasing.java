package mirea.lab3.mathrandom;

import java.util.Random;

public class StrictlyIncreasing {
    public static void main(String[] args) {
        Random rand = new Random();                // генератор случайных чисел
        int[] a = new int[4];

        for (int i = 0; i < a.length; i++) {
            a[i] = 10 + rand.nextInt(90);
        }

        System.out.print("Массив: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        boolean increasing = true;                 // сначала считаем, что массив возрастающий
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) {
                increasing = false;
            }
        }

        if (increasing) {
            System.out.println("Массив является строго возрастающей последовательностью");
        } else {
            System.out.println("Массив не является строго возрастающей последовательностью");
        }
    }
}

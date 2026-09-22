package ru.mirea.lab1;

import java.util.Scanner;

public class Task7 {

    public static long factorial(int n) {
        long result = 1; // long  чтобы факториал большого числа не переполнил int
        for (int i = 2; i <= n; i++) {
            result *= i; // result = result * i
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Факториал отрицательного числа не определён.");
        } else {
            long result = factorial(n);
            System.out.println(n + "! = " + result);
        }
    }
}

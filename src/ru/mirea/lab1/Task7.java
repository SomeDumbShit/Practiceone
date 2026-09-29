package ru.mirea.lab1;

import java.util.Scanner;

public class Task7 {

    public static long factorial(int n) {
 // long  чтобы факториал большого числа не переполнил int
        for (int i = n; i > 0; i--) {
            if(n == 1){
                return 1;
            }
            if(n>1){
                return n * factorial(n-1);
            }// result = result * i
        }
        return 0;
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

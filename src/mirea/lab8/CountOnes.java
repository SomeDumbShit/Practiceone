package mirea.lab8;

import java.util.Scanner;

public class CountOnes {


    public static int countOnes() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            int next = scanner.nextInt();
            if (next == 0) {
                return 0;
            }
            n = next;
        }
        int add = 0;                               // сколько единиц добавилось на этом шаге
        if (n == 1) {
            add = 1;
        }
        return add + countOnes();                  // шаг рекурсии: прибавляем результат для остальных чисел
    }

    public static void main(String[] args) {
        System.out.println("Вводите числа по одному в строке, закончите двумя нулями подряд:");
        System.out.println("Количество единиц: " + countOnes());
    }
}

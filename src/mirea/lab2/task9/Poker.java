package mirea.lab2.task9;

import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество игроков: ");
        int n = scanner.nextInt();

        if (n < 1 || n * 5 > 52) {
            System.out.println("Игроков должно быть от 1 до 10.");
            return;
        }

        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"пики", "червы", "бубны", "трефы"};

        String[] deck = new String[52];
        int index = 0;
        for (int s = 0; s < suits.length; s++) {
            for (int r = 0; r < ranks.length; r++) {
                deck[index] = ranks[r] + " " + suits[s];
                index++;
            }
        }

        for (int i = 0; i < deck.length; i++) {
            int j = (int) (Math.random() * deck.length);  // случайный номер 0..51
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        int card = 0;
        for (int player = 1; player <= n; player++) {
            System.out.println("Игрок " + player + ":");
            for (int k = 0; k < 5; k++) {
                System.out.println("  " + deck[card]);
                card++;
            }
            System.out.println();   // пустая строка между игроками
        }
    }
}

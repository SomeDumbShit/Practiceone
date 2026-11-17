package mirea.lab19;

import java.util.Scanner;

// задание 1: покупка в интернет-магазине с проверкой ИНН
public class PurchaseDriver {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OnlineShop shop = new OnlineShop();
        boolean done = false;
        while (!done) {                            // повторяем ввод, пока заказ не будет оформлен
            System.out.print("ФИО покупателя: ");
            String fio = in.nextLine();
            System.out.print("ИНН: ");
            String inn = in.nextLine().trim();
            try {
                System.out.println(shop.placeOrder(fio, inn));
                done = true;
            } catch (InvalidInnException e) {
                System.out.println("Ошибка ИНН: " + e.getMessage());
            } catch (EmptyStringException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
            if (!done) {
                System.out.println("Повторите ввод");
                System.out.println();
            }
        }
    }
}

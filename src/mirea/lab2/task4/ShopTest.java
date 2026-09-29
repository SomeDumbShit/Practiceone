package mirea.lab2.task4;

import java.util.Scanner;

// пользователь вводит номер действия, а данные - с клавиатуры.
public class ShopTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop(20);

        boolean work = true;   // пока true - меню показывается снова и снова
        while (work) {
            System.out.println("\n Магазинчик ");
            System.out.println("1 - Добавить компьютер");
            System.out.println("2 - Удалить компьютер");
            System.out.println("3 - Найти компьютер");
            System.out.println("4 - Показать все компьютеры");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Производитель: ");
                String brand = scanner.nextLine();
                System.out.print("Модель: ");
                String model = scanner.nextLine();
                System.out.print("Цена: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("ОЗУ (ГБ): ");
                int ram = Integer.parseInt(scanner.nextLine());

                shop.addComputer(new Computer(brand, model, price, ram));

            } else if (choice.equals("2")) {
                System.out.print("Введите модель для удаления: ");
                String model = scanner.nextLine();
                if (shop.removeComputer(model)) {
                    System.out.println("Компьютер удалён.");
                } else {
                    System.out.println("Такой модели нет.");
                }

            } else if (choice.equals("3")) {
                System.out.print("Введите модель для поиска: ");
                String model = scanner.nextLine();
                Computer found = shop.findComputer(model);
                if (found != null) {
                    System.out.println("Найдено: " + found);
                } else {
                    System.out.println("Такой модели нет.");
                }

            } else if (choice.equals("4")) {
                shop.printAll();

            } else if (choice.equals("0")) {
                work = false;
                System.out.println("До свидания!");

            } else {
                System.out.println("Нет такого пункта меню.");
            }
        }
    }
}

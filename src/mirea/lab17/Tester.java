package mirea.lab17;

import java.io.IOException;
import java.util.Scanner;

public class Tester {

    private static final String FILE_NAME = "cards.txt";
    private static final Scanner in = new Scanner(System.in);

    // читает целое число, повторяя запрос при неверном вводе
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число");
            }
        }
    }

    // выбор вида списка
    private static CardList chooseList() {
        System.out.println("Вид списка:");
        System.out.println("1 - односвязный");
        System.out.println("2 - двусвязный");
        System.out.println("3 - кольцевой");
        while (true) {
            int c = readInt("Выбор: ");
            if (c == 1) {
                return new SinglyLinkedList();
            } else if (c == 2) {
                return new DoublyLinkedList();
            } else if (c == 3) {
                return new CircularList();
            }
            System.out.println("Введите 1, 2 или 3");
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1 - добавить студента");
        System.out.println("2 - удалить студента по номеру");
        System.out.println("3 - показать студента по номеру");
        System.out.println("4 - показать всех");
        System.out.println("5 - проверить, пуст ли список");
        System.out.println("6 - очистить список");
        System.out.println("7 - записать в файл");
        System.out.println("8 - прочитать из файла");
        System.out.println("0 - выход");
    }

    public static void main(String[] args) {
        CardList list = chooseList();              // работаем через интерфейс: вид списка не важен
        boolean work = true;
        while (work) {
            printMenu();
            int choice = readInt("Пункт меню: ");
            switch (choice) {
                case 1:
                    StudentCard card = new StudentCard();
                    card.read(in);
                    list.add(card);
                    System.out.println("Добавлено");
                    break;
                case 2:
                    if (list.remove(readInt("Номер: "))) {
                        System.out.println("Удалено");
                    } else {
                        System.out.println("Такого номера нет");
                    }
                    break;
                case 3:
                    list.printElement(readInt("Номер: "));
                    break;
                case 4:
                    list.printAll();
                    break;
                case 5:
                    System.out.println(list.isEmpty() ? "Список пуст" : "В списке элементов: " + list.size());
                    break;
                case 6:
                    list.clear();
                    System.out.println("Список очищен");
                    break;
                case 7:
                    try {
                        list.saveToFile(FILE_NAME);
                        System.out.println("Записано в " + FILE_NAME);
                    } catch (IOException e) {
                        System.out.println("Ошибка записи: " + e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        list.loadFromFile(FILE_NAME);
                        System.out.println("Прочитано из " + FILE_NAME);
                    } catch (IOException | RuntimeException e) {
                        System.out.println("Ошибка чтения: " + e.getMessage());
                    }
                    break;
                case 0:
                    work = false;
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
    }
}

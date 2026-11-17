package mirea.lab19;

import java.util.Scanner;

// задание 2: поиск и сортировка студентов через массив интерфейсных ссылок
public class LabClassDriver {

    private static final Scanner in = new Scanner(System.in);

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

    public static void main(String[] args) {
        LabClassUI[] lists = new LabClassUI[2];    // массив интерфейсных ссылок
        lists[0] = new LabClass("КВБО-12-25");     // каждая ссылка указывает на объект LabClass
        lists[1] = new LabClass("ИКБО-31-23");

        lists[0].add(new Student("Иванова Анна Сергеевна", "КВБО-12-25", 4.7));
        lists[0].add(new Student("Петров Борис Игоревич", "КВБО-12-25", 3.9));
        lists[0].add(new Student("Орлов Дмитрий Андреевич", "КВБО-12-25", 3.5));
        lists[1].add(new Student("Сидоров Виктор Павлович", "ИКБО-31-23", 4.2));
        lists[1].add(new Student("Козлова Галина Олеговна", "ИКБО-31-23", 4.9));
        lists[1].add(new Student("Волкова Елена Максимовна", "ИКБО-31-23", 4.5));

        boolean work = true;
        while (work) {
            System.out.println();
            System.out.println("1 - показать списки");
            System.out.println("2 - отсортировать по баллу (по убыванию)");
            System.out.println("3 - найти студента по ФИО");
            System.out.println("0 - выход");
            int choice = readInt("Пункт меню: ");
            switch (choice) {
                case 1:
                    for (LabClassUI ui : lists) {
                        ui.printAll();
                    }
                    break;
                case 2:
                    for (LabClassUI ui : lists) {
                        ui.sortByGpa();            // вызывается метод LabClass через интерфейсную ссылку
                    }
                    System.out.println("Списки отсортированы");
                    break;
                case 3:
                    System.out.print("ФИО: ");
                    String fio = in.nextLine();
                    try {
                        for (LabClassUI ui : lists) {
                            try {
                                Student s = ui.findByFio(fio);
                                System.out.println("Найден в " + ui.getName() + ": " + s);
                            } catch (StudentNotFoundException e) {
                                System.out.println("В " + ui.getName() + ": " + e.getMessage());
                            }
                        }
                    } catch (EmptyStringException e) {
                        System.out.println("Ошибка: " + e.getMessage());
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

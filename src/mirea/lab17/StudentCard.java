package mirea.lab17;

import java.util.Scanner;

public class StudentCard {
    private String surname;
    private String name;
    private String group;
    private double gpa;

    public StudentCard() {
    }

    public StudentCard(String surname, String name, String group, double gpa) {
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    // считывает атрибуты студента с консоли
    public void read(Scanner in) {
        System.out.print("Фамилия: ");
        surname = in.nextLine().trim();
        System.out.print("Имя: ");
        name = in.nextLine().trim();
        System.out.print("Группа: ");
        group = in.nextLine().trim();
        while (true) {                             // повторяем запрос, пока не введено число
            System.out.print("Балл: ");
            try {
                gpa = Double.parseDouble(in.nextLine().trim().replace(',', '.'));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести число, например 4.5");
            }
        }
    }

    // выводит атрибуты студента на экран
    public void print() {
        System.out.println(this);
    }

    // строка для записи в файл: поля через точку с запятой
    public String toFileLine() {
        return surname + ";" + name + ";" + group + ";" + gpa;
    }

    // создает студента из строки файла
    public static StudentCard fromFileLine(String line) {
        String[] p = line.split(";");
        return new StudentCard(p[0], p[1], p[2], Double.parseDouble(p[3]));
    }

    @Override
    public String toString() {
        return surname + " " + name + ", группа " + group + ", балл " + gpa;
    }
}

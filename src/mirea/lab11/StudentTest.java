package mirea.lab11;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class StudentTest {
    public static void main(String[] args) {
        // дата рождения 14 марта 2006 (месяц задаем константой, чтобы не путаться с нумерацией с нуля)
        Student student = new Student("Анна", "Иванова", new GregorianCalendar(2006, Calendar.MARCH, 14).getTime());

        System.out.println(student);
        System.out.println("Короткий формат: " + student.getBirthDateString("short"));
        System.out.println("Средний формат: " + student.getBirthDateString("medium"));
        System.out.println("Полный формат: " + student.getBirthDateString("full"));
    }
}

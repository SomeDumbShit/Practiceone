package mirea.lab11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DateFromInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел: год месяц(1-12) число часы минуты");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        Calendar calendar = new GregorianCalendar();
        calendar.clear();                          // стираем текущее время, чтобы остались только введенные значения
        calendar.setLenient(false);                // строгая проверка: несуществующая дата вызовет ошибку
        calendar.set(year, month - 1, day, hours, minutes);   // месяц в Calendar с нуля, поэтому вычитаем 1

        try {
            Date date = calendar.getTime();        // здесь Calendar проверяет дату и создает Date
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Объект Date: " + format.format(date));
            System.out.println("Объект Calendar: год " + calendar.get(Calendar.YEAR)
                    + ", месяц " + (calendar.get(Calendar.MONTH) + 1)
                    + ", число " + calendar.get(Calendar.DAY_OF_MONTH)
                    + ", часы " + calendar.get(Calendar.HOUR_OF_DAY)
                    + ", минуты " + calendar.get(Calendar.MINUTE));
        } catch (IllegalArgumentException e) {     // дата не существует
            System.out.println("Такой даты не существует.");
        }
    }
}

package mirea.lab11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.setLenient(false);                  // строгая проверка: даты вроде 31.02.2026 не принимаются

        Date entered = null;                       // введенная дата, пока ее нет
        while (entered == null) {
            System.out.print("Введите дату в формате дд.мм.гггг: ");
            String line = scanner.nextLine().trim();
            try {
                entered = format.parse(line);      // пробуем превратить строку в дату
            } catch (ParseException e) {           // строка не похожа на дату
                System.out.println("Неверный формат, повторите ввод.");
            }
        }

        Date now = new Date();                     // текущие дата и время системы
        SimpleDateFormat full = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Текущее системное время: " + full.format(now));

        if (format.format(entered).equals(format.format(now))) {   // сравниваем только день, без времени
            System.out.println("Введенная дата совпадает с сегодняшней");
        } else if (entered.before(now)) {          // before: дата раньше другой
            System.out.println("Введенная дата раньше текущей");
        } else {
            System.out.println("Введенная дата позже текущей");
        }
    }
}

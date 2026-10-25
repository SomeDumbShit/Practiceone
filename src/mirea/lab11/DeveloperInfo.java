package mirea.lab11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DeveloperInfo {
    public static void main(String[] args) {
        String developer = "Чумаченко";

        // дата и время получения задания (в Calendar месяцы считаются с нуля, поэтому используем константу OCTOBER)
        Calendar received = new GregorianCalendar(2026, Calendar.OCTOBER, 1, 9, 0);
        Date receivedDate = received.getTime();    // превращаем календарь в Date
        Date doneDate = new Date();                // дата и время сдачи: текущее время системы

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");   // шаблон вывода даты
        System.out.println("Разработчик: " + developer);
        System.out.println("Задание получено: " + format.format(receivedDate));
        System.out.println("Задание сдано: " + format.format(doneDate));
    }
}

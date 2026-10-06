package mirea.lab4;

public class SeasonTest {

    // метод принимает значение enum и через switch выводит сообщение
    public static void printLove(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;                             // break нужен, чтобы не выполнились следующие ветки
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
        }
    }

    public static void main(String[] args) {
        Season favorite = Season.SUMMER;           // любимое время года

        System.out.println("Любимое время года: " + favorite);                       // выведется имя константы
        System.out.println("Номер в перечислении: " + favorite.ordinal());           // нумерация с нуля
        System.out.println("Средняя температура: " + favorite.getAverageTemperature());
        System.out.println("Описание: " + favorite.getDescription());

        printLove(favorite);                       // вызываем метод со switch

        System.out.println();
        for (Season s : Season.values()) {         // values() возвращает массив всех констант
            System.out.println(s + ": средняя температура " + s.getAverageTemperature()
                    + ", " + s.getDescription());
        }
    }
}

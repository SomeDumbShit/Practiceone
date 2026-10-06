package mirea.lab6;

import java.util.Scanner;

public class TemperatureApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите температуру по Цельсию: ");
        String line = scanner.nextLine();
        double celsius = Double.parseDouble(line.replace(',', '.'));   // принимаем и точку, и запятую

        if (celsius < -273.15) {                   // ниже абсолютного нуля температуры не бывает
            System.out.println("Температура ниже абсолютного нуля, так не бывает.");
            return;
        }

        Convertable toKelvin = new CelsiusToKelvin();           // переменная типа интерфейса, объект класса
        Convertable toFahrenheit = new CelsiusToFahrenheit();

        System.out.printf("%.2f C = %.2f K%n", celsius, toKelvin.convert(celsius));
        System.out.printf("%.2f C = %.2f F%n", celsius, toFahrenheit.convert(celsius));
    }
}

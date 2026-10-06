package mirea.lab3.format;

import java.util.Scanner;

public class CurrencyApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();   // создаем конвертор

        converter.printRates();
        System.out.println("Доступные валюты: RUB, USD, EUR, CNY");

        System.out.print("Введите сумму: ");
        String line = scanner.nextLine();                           // читаем строку целиком
        double amount = Double.parseDouble(line.replace(',', '.')); // запятую меняем на точку и переводим в число

        System.out.print("Из какой валюты: ");
        String from = scanner.nextLine().trim().toUpperCase();      // убираем пробелы и делаем буквы заглавными

        System.out.print("В какую валюту: ");
        String to = scanner.nextLine().trim().toUpperCase();

        boolean ok = converter.isKnown(from) && converter.isKnown(to);   // обе валюты должны быть в списке
        if (!ok) {
            System.out.println("Такой валюты нет в списке.");
            return;
        }

        double result = converter.convert(amount, from, to);
        System.out.printf("%,.2f %s = %,.2f %s%n", amount, from, result, to);   // %,.2f число с разделителем разрядов и 2 знаками
    }
}

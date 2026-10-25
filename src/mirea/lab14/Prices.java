package mirea.lab14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prices {
    public static void main(String[] args) {
        String text = "Цены: 25.98 USD, 44 ERR, 100 RUB, 0.004 EU, 15.5 EU, 7 USD, 1300.50 RUB.";
        String[] currencies = {"USD", "RUB", "EU"};   // нужные валюты

        System.out.println("Текст: " + text);
        for (int i = 0; i < currencies.length; i++) {
            // число (до двух знаков после точки), пробел и название валюты
            String regex = "(?<![\\d.])\\d+(\\.\\d{1,2})?\\s" + currencies[i] + "\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            System.out.println("Цены в " + currencies[i] + ":");
            while (matcher.find()) {               // find ищет следующее совпадение внутри текста
                System.out.println("  " + matcher.group());   // group возвращает найденный фрагмент
            }
        }
    }
}

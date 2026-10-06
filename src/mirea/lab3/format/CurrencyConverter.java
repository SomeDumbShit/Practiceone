package mirea.lab3.format;

public class CurrencyConverter {
    // курсы
    private double usdRate = 90.0;
    private double eurRate = 100.0;
    private double cnyRate = 12.5;

    // коды валют, которые умеет конвертор
    private String[] codes = {"RUB", "USD", "EUR", "CNY"};

    // проверяет, что такая валюта у нас есть
    public boolean isKnown(String currency) {
        for (int i = 0; i < codes.length; i++) {
            if (codes[i].equals(currency)) {       // строки сравниваем через equals, а не ==
                return true;
            }
        }
        return false;
    }

    // переводит сумму из своей валюты в рубли
    private double toRub(double amount, String currency) {
        switch (currency) {
            case "USD": return amount * usdRate;
            case "EUR": return amount * eurRate;
            case "CNY": return amount * cnyRate;
            default: return amount;
        }
    }

    // переводит рубли в нужную валюту
    private double fromRub(double rub, String currency) {
        switch (currency) {
            case "USD": return rub / usdRate;
            case "EUR": return rub / eurRate;
            case "CNY": return rub / cnyRate;
            default: return rub;
        }
    }

    // главный метод: из любой валюты в любую, через рубли
    public double convert(double amount, String from, String to) {
        double rub = toRub(amount, from);
        return fromRub(rub, to);
    }

    // печатает таблицу курсов с выравниванием
    public void printRates() {
        System.out.println("Курсы (рублей за 1 единицу):");
        System.out.printf("%-5s %8.2f%n", "USD", usdRate);   // %-5s строка шириной 5, влево; %8.2f число шириной 8
        System.out.printf("%-5s %8.2f%n", "EUR", eurRate);
        System.out.printf("%-5s %8.2f%n", "CNY", cnyRate);
    }
}

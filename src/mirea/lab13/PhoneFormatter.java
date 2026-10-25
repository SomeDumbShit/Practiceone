package mirea.lab13;

public class PhoneFormatter {

    // приводит номер к виду +<код><3 цифры>-<3 цифры>-<4 цифры>, при ошибке возвращает null
    public static String format(String phone) {
        String digits;                             // цифры номера без плюса
        if (phone.startsWith("+")) {
            digits = phone.substring(1);           // отбрасываем плюс
        } else if (phone.startsWith("8") && phone.length() == 11) {
            digits = "7" + phone.substring(1);     // для России 8 заменяем кодом страны 7
        } else {
            return null;
        }
        if (digits.length() < 11 || digits.length() > 13) {   // 10 цифр номера и от 1 до 3 цифр кода
            return null;
        }
        for (int i = 0; i < digits.length(); i++) {
            if (!Character.isDigit(digits.charAt(i))) {       // в номере должны быть только цифры
                return null;
            }
        }
        int codeLength = digits.length() - 10;     // номер всегда 10 цифр, все, что левее, это код страны
        String code = digits.substring(0, codeLength);
        String number = digits.substring(codeLength);
        return "+" + code + number.substring(0, 3) + "-" + number.substring(3, 6) + "-" + number.substring(6);
    }

    public static void main(String[] args) {
        String[] phones = {"+79175655655", "+104289652211", "89175655655", "12345", "+7917abc5655"};
        for (int i = 0; i < phones.length; i++) {
            String result = format(phones[i]);
            if (result == null) {
                result = "неверный формат";
            }
            System.out.println(phones[i] + " -> " + result);
        }
    }
}

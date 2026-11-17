package mirea.lab19;

// проверка ИНН физического лица (12 цифр, последние две - контрольные)
public class InnValidator {

    private static final int[] WEIGHTS_11 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};         // веса для 11-й цифры
    private static final int[] WEIGHTS_12 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};      // веса для 12-й цифры

    // если ИНН недействителен, выбрасывает InvalidInnException
    public static void validate(String inn) throws InvalidInnException {
        if (inn == null || inn.isBlank()) {
            throw new InvalidInnException("ИНН не введен");
        }
        if (inn.length() != 12) {
            throw new InvalidInnException("ИНН должен состоять из 12 цифр, введено символов: " + inn.length());
        }
        int[] d = new int[12];
        for (int i = 0; i < 12; i++) {
            char c = inn.charAt(i);
            if (c < '0' || c > '9') {
                throw new InvalidInnException("ИНН должен содержать только цифры, найден символ '" + c + "' на позиции " + (i + 1));
            }
            d[i] = c - '0';                        // код символа минус код нуля дает саму цифру
        }
        if (d[10] != checkDigit(d, WEIGHTS_11) || d[11] != checkDigit(d, WEIGHTS_12)) {
            throw new InvalidInnException("Неверная контрольная сумма ИНН");
        }
    }

    // контрольная цифра: взвешенная сумма цифр, остаток от деления на 11, затем остаток от деления на 10
    private static int checkDigit(int[] d, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += d[i] * weights[i];
        }
        return sum % 11 % 10;
    }
}

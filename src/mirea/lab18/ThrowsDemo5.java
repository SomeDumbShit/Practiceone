package mirea.lab18;

public class ThrowsDemo5 {

    // шаг 1: при ошибочном параметре метод выбрасывает исключение с сообщением
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        // здесь могла бы быть работа с ключом
    }

    // шаг 2: то же самое, но исключение перехватывается внутри самого метода
    public void getDetailsSafe(String key) {
        try {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("key = " + key);
        } catch (NullPointerException e) {
            System.out.println("Caught inside the method: " + e.getMessage());
        }
    }
}

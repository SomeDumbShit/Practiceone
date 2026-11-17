package mirea.lab18;

public class ThrowsDemo6 {

    public void printMessage(String key) {
        String message = getDetails(key);          // исключение из getDetails пройдет через этот метод
        System.out.println(message);
    }

    public String getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    // шаг 3: вызов printMessage обернут в try-catch, программа не ломается
    public void printMessageSafe(String key) {
        try {
            printMessage(key);
        } catch (NullPointerException e) {
            System.out.println("Key is null, nothing to print (" + e.getMessage() + ")");
        }
    }
}

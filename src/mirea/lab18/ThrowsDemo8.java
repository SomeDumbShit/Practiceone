package mirea.lab18;

import java.util.Scanner;

// то же, что ThrowsDemo7, но getKey сам обрабатывает исключение и дает пользователю еще попытку
public class ThrowsDemo8 {

    public void getKey(Scanner myScanner) {        // throws Exception удален
        while (true) {                             // повторяем, пока ключ не будет принят
            System.out.print("Enter key (empty line is an error): ");
            String key = myScanner.nextLine();
            try {
                printDetails(key);
                break;                             // ошибки не было, выходим из цикла
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Try again.");
            }
        }
    }

    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {
        if (key.isEmpty()) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}

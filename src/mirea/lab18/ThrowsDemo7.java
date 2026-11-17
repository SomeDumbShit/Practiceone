package mirea.lab18;

import java.util.Scanner;

// проброс проверяемого исключения через цепочку вызовов с помощью throws
public class ThrowsDemo7 {

    public void getKey(Scanner myScanner) throws Exception {
        System.out.print("Enter key (empty line is an error): ");
        String key = myScanner.nextLine();         // nextLine, а не next: next никогда не вернет пустую строку
        printDetails(key);
    }

    public void printDetails(String key) throws Exception {   // блок try-catch удален, исключение идет выше
        String message = getDetails(key);
        System.out.println(message);
    }

    private String getDetails(String key) throws Exception {  // Exception проверяемое, его надо объявить
        if (key.isEmpty()) {                       // строки сравниваем методами, а не ==
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }
}

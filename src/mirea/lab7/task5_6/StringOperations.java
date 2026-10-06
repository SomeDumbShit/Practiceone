package mirea.lab7.task5_6;

public interface StringOperations {
    int countChars(String s);                      // а) сколько символов в строке
    int countChars(String s, char ch);             // сколько раз встречается символ ch (перегрузка)
    String oddPositions(String s);                 // б) символы на позициях 1, 3, 5 и так далее
    String reverse(String s);                      // в) строка наоборот
}

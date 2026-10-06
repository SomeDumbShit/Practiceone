package mirea.lab7.task5_6;

public class ProcessStrings implements StringOperations {

    @Override
    public int countChars(String s) {
        return s.length();                         // length() возвращает количество символов
    }

    @Override
    public int countChars(String s, char ch) {
        int count = 0;                             // счетчик найденных символов
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {               // charAt(i) возвращает символ с номером i
                count++;
            }
        }
        return count;
    }

    @Override
    public String oddPositions(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i += 2) {  // индексы 0, 2, 4 это позиции 1, 3, 5, потому что позиции считаем с единицы
            result += s.charAt(i);                 // добавляем символ к результату
        }
        return result;
    }

    @Override
    public String reverse(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {   // идем с конца строки к началу
            result += s.charAt(i);
        }
        return result;
    }
}

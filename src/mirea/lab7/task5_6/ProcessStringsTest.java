package mirea.lab7.task5_6;

public class ProcessStringsTest {
    public static void main(String[] args) {
        StringOperations ops = new ProcessStrings();   // переменная типа интерфейса
        String s = "программирование";

        System.out.println("Строка: " + s);
        System.out.println("Количество символов: " + ops.countChars(s));
        System.out.println("Сколько раз встречается 'р': " + ops.countChars(s, 'р'));
        System.out.println("Символы на нечетных позициях: " + ops.oddPositions(s));
        System.out.println("Строка наоборот: " + ops.reverse(s));
    }
}

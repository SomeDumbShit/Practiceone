package mirea.lab13;

public class StringOps {

    // выполняет со строкой все действия задания 1
    public static void process(String s) {
        System.out.println("Строка: " + s);
        System.out.println("Последний символ: " + s.charAt(s.length() - 1));
        System.out.println("Заканчивается на \"!!!\": " + s.endsWith("!!!"));
        System.out.println("Начинается с \"I like\": " + s.startsWith("I like"));
        System.out.println("Содержит \"Java\": " + s.contains("Java"));
        int pos = s.indexOf("Java");               // позиция подстроки, если не найдена, будет -1
        System.out.println("Позиция \"Java\": " + pos);
        System.out.println("Замена a на o: " + s.replace('a', 'o'));
        System.out.println("Верхний регистр: " + s.toUpperCase());
        System.out.println("Нижний регистр: " + s.toLowerCase());
        if (pos >= 0) {
            // вырезаем Java: берем часть до слова и часть после него (в слове 4 буквы)
            System.out.println("Без слова Java: " + s.substring(0, pos) + s.substring(pos + 4));
        }
    }

    public static void main(String[] args) {
        process("I like Java!!!");
    }
}

package mirea.lab3.wrappers;

public class DoubleWrapperDemo {
    public static void main(String[] args) {
        Double d1 = Double.valueOf(3.14);          // из числа
        Double d2 = Double.valueOf("2.5");         // из строки

        // 2. строку превращаем в примитив double
        double fromString = Double.parseDouble("7.75");

        // 3. объект Double переводим во все примитивные типы
        Double d = Double.valueOf(123.987);
        byte b = d.byteValue();
        short s = d.shortValue();
        int i = d.intValue();
        long l = d.longValue();
        float f = d.floatValue();
        double dd = d.doubleValue();

        // 4. выводим значения на консоль
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("parseDouble(\"7.75\") = " + fromString);
        System.out.println("d = " + d);
        System.out.println("byte   = " + b);
        System.out.println("short  = " + s);
        System.out.println("int    = " + i);
        System.out.println("long   = " + l);
        System.out.println("float  = " + f);
        System.out.println("double = " + dd);

        // 5. число превращаем в строку
        String str = Double.toString(3.14);
        System.out.println("Строка: " + str);
    }
}

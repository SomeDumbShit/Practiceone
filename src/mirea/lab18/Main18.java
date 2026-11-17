package mirea.lab18;

import java.util.Scanner;
import java.util.function.Consumer;

public class Main18 {

    private static final Scanner in = new Scanner(System.in);                  // один Scanner на всю программу
    private static final String[] TEST_VALUES = {"Qwerty", "0", "1.2", "1"};   // значения из задания 2

    // читает целое число, повторяя запрос при неверном вводе
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1 - задание 1: деление на ноль");
        System.out.println("2 - задание 2: ввод числа, try-catch");
        System.out.println("3 - задание 3: общий catch по Exception");
        System.out.println("4 - задание 4: блок finally");
        System.out.println("5 - задание 5: свое исключение (throw)");
        System.out.println("6 - задание 6: исключение в цепочке методов");
        System.out.println("7 - задание 7: throws и проброс исключения");
        System.out.println("8 - задание 8: повторный ввод в цикле");
        System.out.println("0 - выход");
    }

    // запускает demo на значениях из задания либо на вводе пользователя
    private static void runDemo(String title, Consumer<Scanner> demo) {
        System.out.println();
        System.out.println(title);
        int mode = readInt("1 - значения из задания (Qwerty, 0, 1.2, 1), 2 - ввести самому: ");
        if (mode == 1) {
            for (String value : TEST_VALUES) {
                System.out.println("Ввод: " + value);
                call(demo, new Scanner(value));    // Scanner читает не с клавиатуры, а из строки
                System.out.println();
            }
        } else {
            call(demo, in);
            if (in.hasNextLine()) {
                in.nextLine();                     // убираем конец строки, оставшийся после next()
            }
        }
    }

    // вызывает demo; исключение, которое никто не перехватил, "роняет" программу - здесь показываем это сообщением
    private static void call(Consumer<Scanner> demo, Scanner source) {
        try {
            demo.accept(source);
        } catch (RuntimeException e) {
            System.out.println("Программа упала: " + e);
        }
    }

    private static void task1() {
        Exception1 demo = new Exception1();
        System.out.println("Шаг 1: 2 / 0 без обработки");
        try {
            demo.exceptionDemoStep1();
        } catch (ArithmeticException e) {
            System.out.println("Программа упала: " + e);
        }
        System.out.println("Шаг 2: 2.0 / 0.0");
        demo.exceptionDemoStep2();
        System.out.println("Шаг 2: деление на ноль с блоком try-catch");
        demo.exceptionDemo();
    }

    private static void task2() {
        Exception2 demo = new Exception2();
        runDemo("Шаг 2: без обработки исключений", demo::exceptionDemoStep1);
        runDemo("Шаг 3: с блоками try-catch", demo::exceptionDemo);
    }

    private static void task3() {
        runDemo("Общий catch по Exception стоит последним", new Exception2()::exceptionDemoGeneral);
    }

    private static void task4() {
        runDemo("Блок finally", new Exception2()::exceptionDemoFinally);
    }

    private static void task5() {
        ThrowsDemo5 demo = new ThrowsDemo5();
        System.out.println("Шаг 1: getDetails(\"abc\")");
        demo.getDetails("abc");
        System.out.println("исключения нет");
        System.out.println("Шаг 1: getDetails(null)");
        try {
            demo.getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("Программа упала: " + e);
        }
        System.out.println("Шаг 2: исключение перехвачено внутри метода");
        demo.getDetailsSafe(null);
    }

    private static void task6() {
        ThrowsDemo6 demo = new ThrowsDemo6();
        System.out.println("Шаг 1: printMessage(\"abc\")");
        demo.printMessage("abc");
        System.out.println("Шаг 2: printMessage(null)");
        try {
            demo.printMessage(null);
        } catch (NullPointerException e) {
            System.out.println("Программа упала: " + e);
            for (int i = 0; i < 2; i++) {          // первые два вызова стека: где выброшено и кто вызвал
                System.out.println("    at " + e.getStackTrace()[i]);
            }
        }
        System.out.println("Шаг 3: printMessageSafe(null)");
        demo.printMessageSafe(null);
    }

    private static void task7() {
        ThrowsDemo7 demo = new ThrowsDemo7();
        try {
            demo.getKey(in);
        } catch (Exception e) {                    // исключение прошло getDetails, printDetails, getKey и дошло сюда
            System.out.println("Исключение дошло до main: " + e.getMessage());
        }
    }

    private static void task8() {
        new ThrowsDemo8().getKey(in);
    }

    public static void main(String[] args) {
        boolean work = true;
        while (work) {
            printMenu();
            int choice = readInt("Задание: ");
            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 0:
                    work = false;
                    break;
                default:
                    System.out.println("Нет такого пункта");
            }
        }
    }
}

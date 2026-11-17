package mirea.lab18;

import java.util.Scanner;

public class Exception2 {

    // задание 2, шаг 1: исключения нигде не перехватываются
    public void exceptionDemoStep1(Scanner myScanner) {
        System.out.print("Enter an integer ");
        String intString = myScanner.next();       // читаем одно слово до пробела
        int i = Integer.parseInt(intString);       // не целое число: NumberFormatException
        System.out.println(2 / i);                 // ноль: ArithmeticException
    }

    // задание 2, шаг 3: каждое исключение перехватывается своим блоком catch
    public void exceptionDemo(Scanner myScanner) {
        System.out.print("Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer: " + intString);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    // задание 3: к списку catch добавлен общий catch по Exception
    public void exceptionDemoGeneral(Scanner myScanner) {
        System.out.print("Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer: " + intString);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } catch (Exception e) {                    // общий catch обязан стоять последним
            System.out.println("Some other error: " + e);
        }
        // если поставить catch (Exception e) первым, код не скомпилируется:
        // последующие catch для подклассов Exception станут недостижимыми
    }

    // задание 4: к решению задания 2 добавлен блок finally
    public void exceptionDemoFinally(Scanner myScanner) {
        System.out.print("Enter an integer ");
        String intString = myScanner.next();
        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer: " + intString);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } finally {
            System.out.println("finally: this block runs in any case");   // выполняется всегда
        }
    }
}

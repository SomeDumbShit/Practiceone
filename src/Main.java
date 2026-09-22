import com.sun.source.tree.NewArrayTree;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        System.out.println("Задание №1");
        int x;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Кол-во вводимых чисел=");
        int summ = 0;
        int len = 0;
        for(x = scanner.nextInt(); x > 0;){
            x -= 1;
            int y = scanner.nextInt();
            summ += y;
            len += 1;
        }
        System.out.print("Сумма = ");
        System.out.println(summ);
        System.out.print("Среднее арифм. = ");
        System.out.println(summ/ len);
        System.out.println("Задание №3");
        for(int b = 1; b <11; b++){
            System.out.println(b + " Элемент: " + 1.0f/b);
            System.out.println("Принимает вид: 1 / " + b);
        }
    }
}
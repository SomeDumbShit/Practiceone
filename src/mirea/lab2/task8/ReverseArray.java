package mirea.lab2.task8;

// Разворачиваем массив строк "на месте" (без второго массива)
public class ReverseArray {
    public static void main(String[] args) {
        String[] arr = {"один", "два", "три", "четыре", "пять"};

        System.out.println("До:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];   // временная переменная для обмена
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println("\nПосле:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

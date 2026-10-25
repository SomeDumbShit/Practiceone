package mirea.lab9_10;

public class InsertionSortTest {


    public static <T extends Comparable<T>> void insertionSort(T[] list) {
        for (int i = 1; i < list.length; i++) {
            T key = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(key) > 0) {   // пока слева стоит элемент больше key
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;                     // нашли место и вставляем key
        }
    }

    public static void main(String[] args) {
        Student[] iDNumber = new Student[5];       // массив студентов
        iDNumber[0] = new Student("Борис", "Петров", "Программная инженерия", 1, "КВБО-11-25", 3.9);
        iDNumber[1] = new Student("Анна", "Иванова", "Программная инженерия", 2, "КВБО-12-25", 4.7);
        iDNumber[2] = new Student("Виктор", "Сидоров", "Информатика", 3, "ИКБО-31-23", 4.2);
        iDNumber[3] = new Student("Галина", "Козлова", "Информатика", 2, "ИКБО-21-24", 4.9);
        iDNumber[4] = new Student("Дмитрий", "Орлов", "Программная инженерия", 1, "КВБО-11-25", 3.5);

        System.out.println("До сортировки:");
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println(iDNumber[i]);
        }

        insertionSort(iDNumber);                   // сортируем по фамилии (по compareTo)

        System.out.println();
        System.out.println("После сортировки вставками по фамилии:");
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println(iDNumber[i]);
        }
    }
}

package mirea.lab9_10;

import java.util.Arrays;
import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student> {

    private Student[] iDNumber;                    // массив студентов

    // правило сравнения: по итоговому баллу по убыванию
    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());   // b и a поменяны местами, поэтому порядок убывающий
    }

    // заполняет массив студентами
    public void setArray() {
        iDNumber = new Student[6];
        iDNumber[0] = new Student("Анна", "Иванова", "Программная инженерия", 2, "КВБО-12-25", 4.7);
        iDNumber[1] = new Student("Борис", "Петров", "Программная инженерия", 1, "КВБО-11-25", 3.9);
        iDNumber[2] = new Student("Виктор", "Сидоров", "Информатика", 3, "ИКБО-31-23", 4.2);
        iDNumber[3] = new Student("Галина", "Козлова", "Информатика", 2, "ИКБО-21-24", 4.9);
        iDNumber[4] = new Student("Дмитрий", "Орлов", "Программная инженерия", 1, "КВБО-11-25", 3.5);
        iDNumber[5] = new Student("Елена", "Волкова", "Информатика", 3, "ИКБО-31-23", 4.5);
    }

    // быстрая сортировка по баллу по убыванию: сравнивает сам этот класс (метод compare выше)
    public void quicksort() {
        doQuickSort(iDNumber, 0, iDNumber.length - 1, this);
    }

    // быстрая сортировка по любому другому правилу (по другому полю)
    public void quicksort(Comparator<Student> cmp) {
        doQuickSort(iDNumber, 0, iDNumber.length - 1, cmp);
    }

    // сортировка слиянием по баллу по убыванию
    public void mergeSort() {
        iDNumber = doMergeSort(iDNumber, this);
    }

    // выводит массив студентов
    public void outArray() {
        for (int i = 0; i < iDNumber.length; i++) {
            System.out.println(iDNumber[i]);
        }
    }

    // сама быстрая сортировка части массива от low до high
    private static void doQuickSort(Student[] a, int low, int high, Comparator<Student> cmp) {
        if (low >= high) {                         // базовый случай: в части 0 или 1 элемент
            return;
        }
        Student pivot = a[(low + high) / 2];       // опорный элемент: средний
        int i = low;                               // левый указатель
        int j = high;                              // правый указатель
        while (i <= j) {
            while (cmp.compare(a[i], pivot) < 0) { // ищем слева элемент, который должен стоять правее опорного
                i++;
            }
            while (cmp.compare(a[j], pivot) > 0) { // ищем справа элемент, который должен стоять левее опорного
                j--;
            }
            if (i <= j) {
                Student temp = a[i];               // меняем найденные элементы местами
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        doQuickSort(a, low, j, cmp);               // рекурсивно сортируем левую часть
        doQuickSort(a, i, high, cmp);              // рекурсивно сортируем правую часть
    }

    // сортировка слиянием: возвращает новый отсортированный массив
    public static Student[] doMergeSort(Student[] a, Comparator<Student> cmp) {
        if (a.length <= 1) {                       // базовый случай: один элемент уже отсортирован
            return a;
        }
        int middle = a.length / 2;
        Student[] left = Arrays.copyOfRange(a, 0, middle);          // левая половина
        Student[] right = Arrays.copyOfRange(a, middle, a.length);  // правая половина
        return merge(doMergeSort(left, cmp), doMergeSort(right, cmp), cmp);   // сортируем половины и сливаем
    }

    // слияние двух уже отсортированных массивов в один отсортированный
    public static Student[] merge(Student[] left, Student[] right, Comparator<Student> cmp) {
        Student[] result = new Student[left.length + right.length];
        int i = 0;                                 // позиция в left
        int j = 0;                                 // позиция в right
        int k = 0;                                 // позиция в result
        while (i < left.length && j < right.length) {
            if (cmp.compare(left[i], right[j]) <= 0) {   // берем тот элемент, который должен идти раньше
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {                  // в left остались элементы, переносим их
            result[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {                 // в right остались элементы, переносим их
            result[k] = right[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        SortingStudentsByGPA sorter = new SortingStudentsByGPA();

        sorter.setArray();
        System.out.println("Исходный массив:");
        sorter.outArray();

        sorter.quicksort();
        System.out.println();
        System.out.println("Быстрая сортировка по баллу (по убыванию):");
        sorter.outArray();

        sorter.setArray();                         // заново заполняем, чтобы сортировать исходный порядок
        sorter.mergeSort();
        System.out.println();
        System.out.println("Сортировка слиянием по баллу (по убыванию):");
        sorter.outArray();

        sorter.setArray();
        sorter.quicksort(new CourseComparator());  // другое поле: курс
        System.out.println();
        System.out.println("Быстрая сортировка по курсу (по возрастанию):");
        sorter.outArray();
    }
}

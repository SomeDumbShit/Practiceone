package mirea.lab19;

import java.util.Arrays;
import java.util.Comparator;

public class LabClass implements LabClassUI {

    private final String name;
    private Student[] students = new Student[4];   // массив студентов, при нехватке места увеличивается
    private int size = 0;                          // сколько студентов в массиве на самом деле

    public LabClass(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void add(Student student) {
        if (size == students.length) {             // массив заполнен: берем вдвое больше
            students = Arrays.copyOf(students, size * 2);
        }
        students[size] = student;
        size++;
    }

    @Override
    public Student findByFio(String fio) throws StudentNotFoundException, EmptyStringException {
        if (fio == null || fio.isBlank()) {
            throw new EmptyStringException("Строка поиска пуста");
        }
        String wanted = Student.normalizeFio(fio);
        for (int i = 0; i < size; i++) {
            if (students[i].getFio().equalsIgnoreCase(wanted)) {   // регистр букв не важен
                return students[i];
            }
        }
        throw new StudentNotFoundException(wanted);   // прошли весь список и не нашли
    }

    @Override
    public void sortByGpa() {
        doQuickSort(students, 0, size - 1, Comparator.comparingDouble(Student::getGpa).reversed());
    }

    @Override
    public void printAll() {
        System.out.println("Список " + name + ":");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + students[i]);
        }
    }

    // быстрая сортировка части массива от low до high по правилу cmp (как в практике 9)
    private static void doQuickSort(Student[] a, int low, int high, Comparator<Student> cmp) {
        if (low >= high) {
            return;
        }
        Student pivot = a[(low + high) / 2];
        int i = low;
        int j = high;
        while (i <= j) {
            while (cmp.compare(a[i], pivot) < 0) {
                i++;
            }
            while (cmp.compare(a[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                Student temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        doQuickSort(a, low, j, cmp);
        doQuickSort(a, i, high, cmp);
    }
}

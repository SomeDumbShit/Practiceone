package mirea.lab9_10;

public class MergeStudentLists {

    // выводит массив студентов с подписью
    private static void print(String title, Student[] list) {
        System.out.println(title);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student[] list1 = new Student[3];          // первый список
        list1[0] = new Student("Анна", "Иванова", "Программная инженерия", 2, "КВБО-12-25", 4.7);
        list1[1] = new Student("Борис", "Петров", "Программная инженерия", 1, "КВБО-11-25", 3.9);
        list1[2] = new Student("Виктор", "Сидоров", "Информатика", 3, "ИКБО-31-23", 4.2);

        Student[] list2 = new Student[3];          // второй список
        list2[0] = new Student("Галина", "Козлова", "Информатика", 2, "ИКБО-21-24", 4.9);
        list2[1] = new Student("Дмитрий", "Орлов", "Программная инженерия", 1, "КВБО-11-25", 3.5);
        list2[2] = new Student("Елена", "Волкова", "Информатика", 3, "ИКБО-31-23", 4.5);

        SortingStudentsByGPA rule = new SortingStudentsByGPA();   // правило сравнения: балл по убыванию

        Student[] sorted1 = SortingStudentsByGPA.doMergeSort(list1, rule);   // сортируем каждый список
        Student[] sorted2 = SortingStudentsByGPA.doMergeSort(list2, rule);
        Student[] all = SortingStudentsByGPA.merge(sorted1, sorted2, rule);  // сливаем в один

        print("Первый список после сортировки:", sorted1);
        print("Второй список после сортировки:", sorted2);
        print("Объединенный отсортированный список:", all);
    }
}

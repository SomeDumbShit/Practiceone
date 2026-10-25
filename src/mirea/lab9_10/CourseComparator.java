package mirea.lab9_10;

import java.util.Comparator;

public class CourseComparator implements Comparator<Student> {

    // сортировка по другому полю: по курсу, по возрастанию
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.getCourse(), b.getCourse());
    }
}

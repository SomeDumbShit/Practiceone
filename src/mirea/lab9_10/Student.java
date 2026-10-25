package mirea.lab9_10;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private String speciality;
    private int course;
    private String group;
    private double gpa;

    public Student(String name, String surname, String speciality, int course, String group, double gpa) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getSpeciality() { return speciality; }
    public void setSpeciality(String speciality) { this.speciality = speciality; }
    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }
    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // естественный порядок студентов: по фамилии, а при одинаковых фамилиях по имени
    @Override
    public int compareTo(Student other) {
        int result = surname.compareTo(other.surname);   // сравнение строк: отрицательное, ноль или положительное число
        if (result == 0) {                         // фамилии совпали
            result = name.compareTo(other.name);   // сравниваем по имени
        }
        return result;
    }

    @Override
    public String toString() {
        return surname + " " + name + ", " + speciality + ", " + course + " курс, группа " + group + ", балл " + gpa;
    }
}

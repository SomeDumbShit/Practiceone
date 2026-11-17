package mirea.lab19;

public class Student {
    private final String fio;
    private final String group;
    private final double gpa;

    public Student(String fio, String group, double gpa) {
        if (fio == null || fio.isBlank()) {
            throw new EmptyStringException("ФИО студента не задано");
        }
        if (group == null || group.isBlank()) {
            throw new EmptyStringException("Группа студента не задана");
        }
        if (gpa < 0 || gpa > 5) {
            throw new IllegalArgumentException("Балл должен быть от 0 до 5: " + gpa);
        }
        this.fio = normalizeFio(fio);
        this.group = group.trim();
        this.gpa = gpa;
    }

    // убирает лишние пробелы: "  Иванов   Иван " -> "Иванов Иван"
    public static String normalizeFio(String fio) {
        return fio.trim().replaceAll("\\s+", " ");
    }

    public String getFio() {
        return fio;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return fio + ", группа " + group + ", балл " + gpa;
    }
}

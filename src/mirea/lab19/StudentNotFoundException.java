package mirea.lab19;

// проверяемое исключение: студента с таким ФИО нет в списке
public class StudentNotFoundException extends Exception {

    private final String fio;                      // ФИО, которое искали

    public StudentNotFoundException(String fio) {
        super("Студент не найден: " + fio);
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }
}

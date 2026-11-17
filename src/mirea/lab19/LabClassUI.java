package mirea.lab19;

// пользовательский интерфейс (интерфейс Java) для задачи поиска и сортировки студентов
public interface LabClassUI {

    String getName();                              // название списка

    void add(Student student);                     // добавить студента

    // поиск по ФИО; если студента нет, выбрасывается свое исключение
    Student findByFio(String fio) throws StudentNotFoundException, EmptyStringException;

    void sortByGpa();                              // сортировка по баллу по убыванию

    void printAll();                               // вывод списка
}

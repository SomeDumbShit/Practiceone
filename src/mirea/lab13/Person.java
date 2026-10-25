package mirea.lab13;

public class Person {
    private String surname;                        // фамилия
    private String name;                           // имя, может отсутствовать
    private String patronymic;                     // отчество, может отсутствовать

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    // возвращает "Фамилия И.О." с учетом того, что имени или отчества может не быть
    public String getShortName() {
        boolean hasName = name != null && !name.isEmpty();
        boolean hasPatronymic = patronymic != null && !patronymic.isEmpty();

        StringBuilder sb = new StringBuilder(surname.length() + 5);   // StringBuilder быстрее, чем склеивание строк плюсом
        sb.append(surname);
        if (hasName || hasPatronymic) {
            sb.append(' ');                        // пробел после фамилии нужен, только если есть инициалы
        }
        if (hasName) {
            sb.append(name.charAt(0)).append('.'); // первая буква имени и точка
        }
        if (hasPatronymic) {
            sb.append(patronymic.charAt(0)).append('.');
        }
        return sb.toString();
    }
}

package mirea.lab11;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String name;                           // имя
    private String surname;                        // фамилия
    private Date birthDate;                        // дата рождения

    public Student(String name, String surname, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Date getBirthDate() { return birthDate; }

    // дата рождения строкой: formatName это "short", "medium" или "full"
    public String getBirthDateString(String formatName) {
        int style;                                 // стиль формата даты
        switch (formatName) {
            case "short":
                style = DateFormat.SHORT;
                break;
            case "full":
                style = DateFormat.FULL;
                break;
            default:
                style = DateFormat.MEDIUM;         // любое другое слово считаем средним форматом
        }
        DateFormat format = DateFormat.getDateInstance(style, Locale.forLanguageTag("ru-RU"));   // формат для русской локали
        return format.format(birthDate);
    }

    @Override
    public String toString() {
        return surname + " " + name + ", дата рождения: " + getBirthDateString("medium");
    }
}

package mirea.lab17;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public interface CardList {

    boolean isEmpty();                             // проверка списка на пустоту

    int size();                                    // количество элементов

    void add(StudentCard card);                    // добавление элемента в конец списка

    boolean remove(int index);                     // удаление элемента по номеру (с нуля)

    StudentCard get(int index);                    // элемент по номеру

    void clear();                                  // очистка списка

    void printAll();                               // вывод всех элементов

    // вывод одного элемента (узла) на экран
    default void printElement(int index) {
        StudentCard card = get(index);
        if (card == null) {
            System.out.println("Элемента с номером " + index + " нет");
        } else {
            System.out.print(index + ": ");
            card.print();
        }
    }

    // запись списка в файл
    default void saveToFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            lines.add(get(i).toFileLine());
        }
        Files.write(Paths.get(fileName), lines, StandardCharsets.UTF_8);
    }

    // чтение списка из файла (старое содержимое списка удаляется)
    default void loadFromFile(String fileName) throws IOException {
        clear();
        for (String line : Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            if (!line.isBlank()) {
                add(StudentCard.fromFileLine(line));
            }
        }
    }
}

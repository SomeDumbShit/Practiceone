package mirea.lab2.task7;


public class BookShelf {
    private Book[] books;
    private int count;     // количество книг на полке

    public BookShelf(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Полка заполнена!");
        }
    }

    // Самая ранняя книга (минимальный год)
    public Book getEarliest() {
        if (count == 0) {
            return null;
        }
        Book result = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() < result.getYear()) {
                result = books[i];
            }
        }
        return result;
    }

    // Самая поздняя книга (максимальный год)
    public Book getLatest() {
        if (count == 0) {
            return null;
        }
        Book result = books[0];
        for (int i = 1; i < count; i++) {
            if (books[i].getYear() > result.getYear()) {
                result = books[i];
            }
        }
        return result;
    }


    // соседние книги сравниваем и, если порядок неверный, меняем местами
    public void sortByYear() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (books[j].getYear() > books[j + 1].getYear()) {
                    Book temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ") " + books[i]);
        }
    }

    public static void main(String[] args) {
        BookShelf shelf = new BookShelf(10);
        shelf.addBook(new Book("Л. Толстой", "Война и мир", 1869));
        shelf.addBook(new Book("М. Булгаков", "Мастер и Маргарита", 1967));
        shelf.addBook(new Book("А. Пушкин", "Евгений Онегин", 1833));
        shelf.addBook(new Book("Ф. Достоевский", "Идиот", 1869));

        System.out.println("Книги на полке:");
        shelf.printAll();

        System.out.println("\nСамая ранняя: " + shelf.getEarliest());
        System.out.println("Самая поздняя: " + shelf.getLatest());

        shelf.sortByYear();
        System.out.println("\nПосле сортировки по году:");
        shelf.printAll();
    }
}

package mirea.lab7.task7_8;

public class Book implements Printable {
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году%n", name, author, year);
    }

    // печатает названия только книг из массива
    public static void printBooks(Printable[] printable) {
        for (int i = 0; i < printable.length; i++) {
            if (printable[i] instanceof Book) {    // проверяем, что в этой ячейке именно книга
                Book book = (Book) printable[i];   // приводим тип к Book, чтобы вызвать getName()
                System.out.println(book.getName());
            }
        }
    }
}

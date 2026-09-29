package mirea.lab2.task7;


public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("А. С. Пушкин", "Капитанская дочка", 1836);
        System.out.println(book);

        book.setYear(1837);
        book.setTitle("Евгений Онегин");
        System.out.println("После изменений: " + book);
        System.out.println("Автор: " + book.getAuthor() + ", год: " + book.getYear());
    }
}

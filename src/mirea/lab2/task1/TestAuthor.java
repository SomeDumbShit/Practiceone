package mirea.lab2.task1;

// Класс для проверки работы класса Author
public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Лев Толстой", "tolstoy@mail.ru", 'm');
        System.out.println(author);                       // вызовется toString()
        System.out.println("Имя: " + author.getName());
        System.out.println("Email: " + author.getEmail());
        System.out.println("Пол: " + author.getGender());
        // Меняем email через сеттер
        author.setEmail("lev@yandex.ru");
        System.out.println("После изменения: " + author);
    }
}

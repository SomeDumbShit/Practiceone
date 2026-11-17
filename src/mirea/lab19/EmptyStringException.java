package mirea.lab19;

// непроверяемое исключение (наследник RuntimeException): пустая строка там, где нужен текст
public class EmptyStringException extends RuntimeException {

    public EmptyStringException(String errorMessage) {
        super(errorMessage);                       // сообщение передаем конструктору родителя
    }
}

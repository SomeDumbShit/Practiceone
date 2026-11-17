package mirea.lab19;

// проверяемое исключение (наследник Exception): недействительный ИНН
public class InvalidInnException extends Exception {

    public InvalidInnException(String errorMessage) {
        super(errorMessage);
    }

    // вариант с причиной: исходное исключение сохраняется внутри нового
    public InvalidInnException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

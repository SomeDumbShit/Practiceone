package mirea.lab19;

public class OnlineShop {

    // оформление заказа: проверяет ФИО и ИНН покупателя
    public String placeOrder(String fio, String inn) throws InvalidInnException {
        if (fio == null || fio.isBlank()) {
            throw new EmptyStringException("ФИО не введено");
        }
        InnValidator.validate(inn);                // недействительный ИНН: исключение уходит вызывающему коду
        return "Заказ оформлен: " + fio.trim() + ", ИНН " + inn;
    }
}

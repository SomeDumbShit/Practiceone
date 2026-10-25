package mirea.lab13;

public class Shirt {
    private String id;                             // артикул
    private String description;                    // описание
    private String color;                          // цвет
    private String size;                           // размер

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    // объяснение и значение каждого поля с новой строки (\n это перевод строки)
    @Override
    public String toString() {
        return "Артикул: " + id + "\n"
                + "Описание: " + description + "\n"
                + "Цвет: " + color + "\n"
                + "Размер: " + size;
    }
}

package mirea.lab7.task7_8;

public class PrintableTest {
    public static void main(String[] args) {
        Printable[] items = new Printable[4];      // в одном массиве лежат и книги, и журналы
        items[0] = new Book("Война и мир", "Л. Н. Толстой", 1869);
        items[1] = new Magazine("Хакер");
        items[2] = new Book("Отцы и дети", "И. С. Тургенев", 1862);
        items[3] = new Magazine("Компьютерра");

        System.out.println("Все объекты:");
        for (int i = 0; i < items.length; i++) {
            items[i].print();                      // у каждого объекта сработает свой print()
        }

        System.out.println();
        System.out.println("Только книги:");
        Book.printBooks(items);

        System.out.println();
        System.out.println("Только журналы:");
        Magazine.printMagazines(items);
    }
}

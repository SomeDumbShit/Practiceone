package mirea.lab7.task7_8;

public class Magazine implements Printable {
    private String name;                           // название журнала

    public Magazine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.printf("Журнал '%s'%n", name);
    }

    // печатает названия только журналов из массива
    public static void printMagazines(Printable[] printable) {
        for (int i = 0; i < printable.length; i++) {
            if (printable[i] instanceof Magazine) {
                Magazine magazine = (Magazine) printable[i];
                System.out.println(magazine.getName());
            }
        }
    }
}

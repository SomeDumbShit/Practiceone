package mirea.lab13;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Person("Иванов", "Иван", "Иванович");   // есть все
        people[1] = new Person("Петрова", "Анна", null);         // нет отчества
        people[2] = new Person("Сидоров", "", "Петрович");       // нет имени
        people[3] = new Person("Козлов", null, null);            // есть только фамилия

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i].getShortName());
        }
    }
}

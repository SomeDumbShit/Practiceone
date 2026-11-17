package mirea.lab20;

// наследник Animal, который НЕ реализует Serializable: под ограничение для V не подходит
public class Fish extends Animal {

    public Fish(String name) {
        super(name);
    }
}

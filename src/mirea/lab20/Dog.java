package mirea.lab20;

import java.io.Serializable;

// наследник Animal, который к тому же реализует Serializable: подходит под ограничение для V
public class Dog extends Animal implements Serializable {

    public Dog(String name) {
        super(name);
    }
}

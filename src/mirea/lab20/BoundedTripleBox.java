package mirea.lab20;

import java.io.Serializable;

// задание 3: те же три параметра, но с ограничениями
// T - сравнимый тип (Integer, Double, String и другие, реализующие Comparable)
// V - наследник Animal, реализующий Serializable (через & перечисляются дополнительные границы)
// K - без ограничений: в задании для K ограничение не указано
public class BoundedTripleBox<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private final T first;
    private final V second;
    private final K third;

    public BoundedTripleBox(T first, V second, K third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public K getThird() {
        return third;
    }

    // благодаря границе T extends Comparable<T> здесь доступен compareTo
    public int compareFirstTo(T other) {
        return first.compareTo(other);
    }

    // благодаря границе V extends Animal здесь доступен getName
    public String animalName() {
        return second.getName();
    }

    public void printClassNames() {
        System.out.println("T: " + first.getClass().getName());
        System.out.println("V: " + second.getClass().getName());
        System.out.println("K: " + (third == null ? "null" : third.getClass().getName()));
    }
}

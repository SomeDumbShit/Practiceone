package mirea.lab20;

// задания 1-2: обобщенный класс с тремя параметрами типа T, V, K
public class TripleBox<T, V, K> {
    private final T first;
    private final V second;
    private final K third;

    public TripleBox(T first, V second, K third) {
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

    // выводит на консоль имена классов трех переменных
    public void printClassNames() {
        System.out.println("T: " + nameOf(first));
        System.out.println("V: " + nameOf(second));
        System.out.println("K: " + nameOf(third));
    }

    private static String nameOf(Object o) {
        return o == null ? "null" : o.getClass().getName();
    }
}

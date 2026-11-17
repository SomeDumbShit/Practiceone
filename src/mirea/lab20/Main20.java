package mirea.lab20;

public class Main20 {

    public static void main(String[] args) {
        System.out.println("--- Задания 1-2: TripleBox<T, V, K> ---");
        TripleBox<Integer, String, Double> box = new TripleBox<>(10, "text", 2.5);
        System.out.println(box.getFirst() + " " + box.getSecond() + " " + box.getThird());
        box.printClassNames();

        System.out.println();
        System.out.println("--- Задание 3: BoundedTripleBox с ограничениями ---");
        BoundedTripleBox<Integer, Dog, String> b1 = new BoundedTripleBox<>(5, new Dog("Rex"), "info");
        b1.printClassNames();
        System.out.println("compareFirstTo(3) = " + b1.compareFirstTo(3));
        System.out.println("animalName() = " + b1.animalName());
        BoundedTripleBox<String, Dog, Integer> b2 = new BoundedTripleBox<>("abc", new Dog("Bobik"), 7);
        System.out.println("compareFirstTo(\"abd\") = " + b2.compareFirstTo("abd"));
        // не скомпилируется:
        // new BoundedTripleBox<Object, Dog, String>(...)   - Object не реализует Comparable
        // new BoundedTripleBox<Integer, Fish, String>(...) - Fish не реализует Serializable
        // new BoundedTripleBox<Integer, String, String>(...) - String не наследует Animal

        System.out.println();
        System.out.println("--- Задание 4: MinMax ---");
        MinMax<Integer> ints = new MinMax<>(new Integer[]{5, 2, 9, -1, 7});
        System.out.println("Integer: min = " + ints.min() + ", max = " + ints.max());
        MinMax<String> words = new MinMax<>(new String[]{"pear", "apple", "zebra", "mango"});
        System.out.println("String: min = " + words.min() + ", max = " + words.max());
        MinMax<Double> doubles = new MinMax<>(new Double[]{2.5, 0.1, 7.75});
        System.out.println("Double: min = " + doubles.min() + ", max = " + doubles.max());

        System.out.println("Calculator:");
        System.out.println("sum(5, 2.5) = " + Calculator.sum(5, 2.5));
        System.out.println("subtraction(10L, 3) = " + Calculator.subtraction(10L, 3));
        System.out.println("multiply(3, 1.5f) = " + Calculator.multiply(3, 1.5f));
        System.out.println("divide(7, 2) = " + Calculator.divide(7, 2));
        try {
            Calculator.divide(1, 0);
        } catch (ArithmeticException e) {
            System.out.println("divide(1, 0): " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Задание 5: Matrix ---");
        Matrix<Integer> a = new Matrix<>(new Integer[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix<Double> b = new Matrix<>(new Double[][]{{0.5, 1.5, 2.0}, {1.0, 0.0, -1.0}});
        Matrix<Integer> c = new Matrix<>(new Integer[][]{{1, 0}, {2, 1}, {0, 3}});
        System.out.println("A:");
        System.out.print(a);
        System.out.println("B:");
        System.out.print(b);
        System.out.println("A + B:");
        System.out.print(a.add(b));
        System.out.println("A - B:");
        System.out.print(a.subtract(b));
        System.out.println("A * C:");
        System.out.print(a.multiply(c));
        System.out.println("A * 2:");
        System.out.print(a.multiplyByNumber(2));
        System.out.println("A транспонированная:");
        System.out.print(a.transpose());
        try {
            a.multiply(b);
        } catch (IllegalArgumentException e) {
            System.out.println("A * B: " + e.getMessage());
        }
    }
}

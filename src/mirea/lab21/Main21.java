package mirea.lab21;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main21 {

    public static void main(String[] args) {
        System.out.println("--- Задание 1: массив в список ---");
        List<String> words = ArrayUtils.toList(new String[]{"one", "two", "three"});
        List<Integer> numbers = ArrayUtils.toList(new Integer[]{55, 66, 77});
        List<Integer> fromInts = ArrayUtils.toList(new int[]{1, 2, 3});
        System.out.println(words + " " + numbers + " " + fromInts);
        System.out.println(ArrayUtils.<Integer>toList(new Integer[]{8, 9}));   // тип можно указать явно: после точки в <>

        System.out.println();
        System.out.println("--- Задания 2-3: ArrayStore и элемент по индексу ---");
        ArrayStore<Integer> ints = ArrayStore.ofInts(new int[]{10, 20, 30});
        ArrayStore<Long> longs = ArrayStore.ofLongs(new long[]{1L, 2L, 3000000000L});
        ArrayStore<String> strings = new ArrayStore<>(new String[]{"a", "b", "c"});
        System.out.println(ints + " " + longs + " " + strings);
        System.out.println("ints.get(1) = " + ints.get(1));
        System.out.println("longs.get(2) = " + longs.get(2));
        System.out.println("strings.get(0) = " + strings.get(0));
        try {
            ints.get(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ints.get(5): " + e.getMessage());
        }

        System.out.println();
        System.out.println("--- Задание 4: каталог ---");
        String path = args.length > 0 ? args[0] : ".";    // путь можно передать аргументом, по умолчанию текущий каталог
        try {
            DirectoryLister.printFirstFive(path);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("--- Задание 5: Solution ---");
        System.out.println(Solution.newArrayList("x", "y", "z"));
        System.out.println(Solution.<Integer>newHashSet(1, 2, 2, 3));      // множество убирает повторы
        Map<String, Integer> source = new HashMap<>();
        source.put("one", 1);
        source.put("two", 2);
        HashMap<Object, Number> copy = Solution.newHashMap(source);        // K = Object, V = Number: подтипы подходят
        System.out.println(copy);
    }
}

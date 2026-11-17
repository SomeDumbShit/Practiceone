package mirea.lab21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// задание 5: вспомогательные методы, которые создают коллекцию и помещают в нее переданные объекты
public class Solution {

    @SafeVarargs                                   // метод только читает элементы varargs-массива
    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<>();
        for (T element : elements) {
            set.add(element);
        }
        return set;
    }

    // K - тип ключа, V - тип значения; принимаем карту с ключами и значениями любых подтипов K и V
    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        HashMap<K, V> result = new HashMap<>();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}

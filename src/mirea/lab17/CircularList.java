package mirea.lab17;

// односвязный кольцевой список: последний узел ссылается на первый
public class CircularList implements CardList {

    private static class Node {
        StudentCard data;
        Node next;

        Node(StudentCard data) {
            this.data = data;
        }
    }

    private Node last;                             // последний узел; last.next - первый узел
    private int size;

    // создание пустого списка
    public CircularList() {
        last = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(StudentCard card) {
        Node node = new Node(card);
        if (last == null) {                        // единственный узел ссылается сам на себя
            node.next = node;
        } else {
            node.next = last.next;                 // новый узел замыкает кольцо на первый
            last.next = node;                      // старый последний ссылается на новый
        }
        last = node;
        size++;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (size == 1) {                           // удаляем единственный узел
            last = null;
        } else {
            Node prev = last;                      // узел перед первым - последний
            for (int i = 0; i < index; i++) {      // встаем на узел перед удаляемым
                prev = prev.next;
            }
            Node cur = prev.next;                  // удаляемый узел
            prev.next = cur.next;                  // обходим его
            if (cur == last) {                     // удалили последний: последним становится предыдущий
                last = prev;
            }
        }
        size--;
        return true;
    }

    @Override
    public StudentCard get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node cur = last.next;                      // начинаем с первого узла
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public void clear() {
        last = null;
        size = 0;
    }

    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node cur = last.next;
        for (int i = 0; i < size; i++) {           // идем по кругу ровно size раз, иначе цикл бесконечен
            System.out.print(i + ": ");
            cur.data.print();
            cur = cur.next;
        }
    }
}

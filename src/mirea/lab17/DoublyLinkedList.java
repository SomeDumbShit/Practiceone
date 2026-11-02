package mirea.lab17;

// двусвязный список
public class DoublyLinkedList implements CardList {

    // узел списка: данные, ссылка на предыдущий и на следующий узлы
    private static class Node {
        StudentCard data;
        Node prev;
        Node next;

        Node(StudentCard data) {
            this.data = data;
        }
    }

    private Node begin;                            // первый узел
    private Node end;                              // последний узел
    private int size;

    // создание пустого списка
    public DoublyLinkedList() {
        begin = null;
        end = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return begin == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(StudentCard card) {
        Node node = new Node(card);
        if (end == null) {                         // список пуст: узел и первый, и последний
            begin = node;
            end = node;
        } else {
            node.prev = end;                       // новый узел смотрит назад на старый последний
            end.next = node;                       // старый последний смотрит вперед на новый
            end = node;
        }
        size++;
    }

    // находит узел по номеру, идя с ближнего конца
    private Node nodeAt(int index) {
        Node cur;
        if (index < size / 2) {                    // номер в первой половине: идем с начала
            cur = begin;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        } else {                                   // во второй половине: идем с конца
            cur = end;
            for (int i = size - 1; i > index; i--) {
                cur = cur.prev;
            }
        }
        return cur;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node cur = nodeAt(index);
        if (cur.prev == null) {                    // удаляем первый узел
            begin = cur.next;
        } else {
            cur.prev.next = cur.next;              // предыдущий узел теперь ссылается на следующий
        }
        if (cur.next == null) {                    // удаляем последний узел
            end = cur.prev;
        } else {
            cur.next.prev = cur.prev;              // следующий узел теперь ссылается на предыдущий
        }
        size--;
        return true;
    }

    @Override
    public StudentCard get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return nodeAt(index).data;
    }

    @Override
    public void clear() {
        begin = null;
        end = null;
        size = 0;
    }

    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node cur = begin;
        int i = 0;
        while (cur != null) {
            System.out.print(i + ": ");
            cur.data.print();
            cur = cur.next;
            i++;
        }
    }
}

package mirea.lab17;

// односвязный список
public class SinglyLinkedList implements CardList {

    // узел списка: данные и ссылка на следующий узел
    private static class Node {
        StudentCard data;
        Node next;

        Node(StudentCard data) {
            this.data = data;
        }
    }

    private Node head;                             // первый узел (null, если список пуст)
    private int size;                              // количество узлов

    // создание пустого списка
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(StudentCard card) {
        Node node = new Node(card);
        if (head == null) {                        // список пуст: новый узел становится первым
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) {             // идем до последнего узла
                cur = cur.next;
            }
            cur.next = node;                       // дописываем новый узел после последнего
        }
        size++;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {          // такого номера нет
            return false;
        }
        if (index == 0) {                          // удаляем первый узел
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {  // встаем на узел перед удаляемым
                prev = prev.next;
            }
            prev.next = prev.next.next;            // перекидываем ссылку через удаляемый узел
        }
        size--;
        return true;
    }

    @Override
    public StudentCard get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public void clear() {
        head = null;                               // остальные узлы соберет сборщик мусора
        size = 0;
    }

    @Override
    public void printAll() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {                      // идем до конца списка (null)
            System.out.print(i + ": ");
            cur.data.print();
            cur = cur.next;
            i++;
        }
    }
}

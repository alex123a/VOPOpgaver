import java.util.LinkedList;

public class FastLinkedList<E> {
    LinkedList<E> linkedList;
    public FastLinkedList() {
        linkedList = new LinkedList<>();
    }

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E get() {
        return linkedList.getFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}

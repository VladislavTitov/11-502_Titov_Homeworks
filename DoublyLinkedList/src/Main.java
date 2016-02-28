public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addFirst(1);
        dll.addLast(2);
        dll.addLast(3);
        dll.addLast(4);
        dll.addLast(5);

        dll.iterator.next();
        dll.iterator.next();
        dll.iterator.next();

        dll.insert(6);

        dll.showList();
    }
}

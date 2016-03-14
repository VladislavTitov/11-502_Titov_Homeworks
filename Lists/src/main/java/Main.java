public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> b = new DoublyLinkedList<>();

        a.addLast(1);
        a.addLast(4);
        a.addLast(7);
        a.addLast(9);
        a.addLast(19);

        b.addLast(2);
        b.addLast(3);
        b.addLast(6);
        b.addLast(10);

        DoublyLinkedList<Integer> c = DoublyLinkedList.merge(a, b);

        c.showList();

    }
}
